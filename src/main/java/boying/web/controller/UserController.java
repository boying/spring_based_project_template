package boying.web.controller;

import boying.dto.user.LoginParam;
import boying.dto.user.LoginResult;
import boying.service.user.LoginService;
import boying.service.user.UserService;
import boying.web.form.LoginForm;
import boying.web.interceptor.RequestUser;
import boying.web.response.BaseResponse;
import boying.web.response.ErrorCode;
import boying.web.utils.WebConstant;
import boying.web.utils.WebUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by boying on 2017/7/24.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private UserService userService;
    @Autowired
    private RequestUser requestUser;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse login(@RequestBody LoginForm loginForm, HttpServletResponse httpServletResponse) {
        LoginParam loginParam = new LoginParam();
        BeanUtils.copyProperties(loginForm, loginParam);
        LoginResult loginResult = loginService.login(loginParam);
        if (loginResult.isLoginSuccess()) {
            httpServletResponse.addCookie(genLoginSuccessCookie(loginResult.getSessionId()));
            return BaseResponse.success();
        } else {
            return new BaseResponse(ErrorCode.USER_LOGIN_FAILED);
        }
    }

    private Cookie genLoginSuccessCookie(String sessionId) {
        Cookie cookie = new Cookie(WebConstant.SID, sessionId);
        cookie.setDomain(""); // TODO
        cookie.setMaxAge(-1);
        cookie.setPath(""); // TODO
        return cookie;
    }

    @ResponseBody
    @RequestMapping(value = "/logout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        loginService.logout(WebUtils.getCookie(httpServletRequest, WebConstant.SID));
        httpServletResponse.addCookie(genLogoutCookie());
        return BaseResponse.success();
    }

    private Cookie genLogoutCookie() {
        Cookie cookie = new Cookie(WebConstant.SID, "");
        cookie.setDomain(""); // TODO
        cookie.setMaxAge(-1);
        cookie.setPath(""); // TODO
        return cookie;
    }
}
