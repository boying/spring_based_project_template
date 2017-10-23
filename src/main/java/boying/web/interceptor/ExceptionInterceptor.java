package boying.web.interceptor;

import boying.web.response.BaseResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by boying on 2017/7/24.
 */
public class ExceptionInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionInterceptor.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        if (e == null) {
            return;
        }

        logger.error("exception catch: ", e);
        httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write(mapper.writeValueAsString(BaseResponse.sysErr()));
        writer.flush();
        // TODO need close?
        //writer.close();
    }
}
