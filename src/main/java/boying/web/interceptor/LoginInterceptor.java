package boying.web.interceptor;

import boying.common.gson.GsonUtils;
import boying.service.user.UserService;
import boying.service.user.UserSessionService;
import boying.web.response.BaseResponse;
import boying.web.response.ErrorCode;
import boying.web.utils.WebUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by boying on 2017/7/24.
 */
public class LoginInterceptor implements HandlerInterceptor {
    private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    private static ObjectMapper mapper = new ObjectMapper();

    private static final String COOKIE_USER_SESSION_ID = "sid";

    @Autowired
    private UserService userService;

    @Value("#{loginWhiteList.login_white_list}")
    private String rawWhiteList;

    @Autowired
    private UserSessionService userSessionService;

    @Autowired
    private RequestUser requestUser;

    private Map<RequestMethod, List<Pattern>> methodPatternsMap = new HashMap<>();
    private String redirectUrl;

    @PostConstruct
    private void initWhiteList() {
        if (rawWhiteList == null) {
            return;
        }

        String[] splits = rawWhiteList.split(",");
        for (String split : splits) {
            String[] ss = split.split(" ");
            String method = ss[0].trim();
            String regex = ss[1].trim();
            method = method.toUpperCase();
            RequestMethod requestMethod = RequestMethod.valueOf(method);
            List<Pattern> patterns;
            if (methodPatternsMap.containsKey(requestMethod)) {
                patterns = methodPatternsMap.get(requestMethod);
            } else {
                patterns = new ArrayList<>();
                methodPatternsMap.put(requestMethod, patterns);
            }

            patterns.add(Pattern.compile(regex));
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.info("LoginInterceptor#preHandle into");

        if (inWhiteList(httpServletRequest)) {
            return true;
        }

        String sid = WebUtils.getCookie(httpServletRequest, COOKIE_USER_SESSION_ID);
        if (sid == null) {
            whenNotLogined(httpServletRequest, httpServletResponse);
            return false;
        }

        Long userId = userSessionService.getUserIdBySessionId(sid);
        if (userId == null) {
            whenNotLogined(httpServletRequest, httpServletResponse);
            return false;
        }
        userSessionService.keepSession(sid);

        requestUser.registerUser(userId);

        return true;
    }

    private void whenNotLogined(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        if (WebUtils.isAjaxRequest(httpServletRequest)) {
            whenAjaxNotLogined(httpServletRequest, httpServletResponse);
        } else {
            whenPageNotLogined(httpServletRequest, httpServletResponse);
        }
    }

    private void whenPageNotLogined(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String redirect = this.redirectUrl;
        if (WebUtils.isGetRequest(httpServletRequest)) {
            redirect = this.redirectUrl + "?redirect=" + WebUtils.encodeUrl(httpServletRequest);
        }

        try {
            httpServletResponse.sendRedirect(redirect);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private void whenAjaxNotLogined(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setStatus(401);
        PrintWriter output;
        try {
            output = httpServletResponse.getWriter();
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }

        output.write(GsonUtils.getGson().toJson(new BaseResponse<>(ErrorCode.NOT_LOGIN)));
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        requestUser.unregisterUser();
    }

    private boolean inWhiteList(HttpServletRequest httpServletRequest) {
        RequestMethod requestMethod = RequestMethod.valueOf(httpServletRequest.getMethod());
        if (!methodPatternsMap.containsKey(requestMethod)) {
            return false;
        }

        List<Pattern> patterns = methodPatternsMap.get(requestMethod);
        for (Pattern pattern : patterns) {
            if (pattern.matcher(httpServletRequest.getServletPath()).matches()) {
                return true;
            }
        }

        return false;
    }

    private void notLogin(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write(mapper.writeValueAsString(BaseResponse.buildResponse(ErrorCode.USER_NOT_LOGIN)));
        writer.flush();
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
