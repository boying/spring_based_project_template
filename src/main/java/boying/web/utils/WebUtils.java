package boying.web.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;

/**
 * Created by boying on 2017/10/23.
 */
public class WebUtils {
    public static String getCookie(HttpServletRequest httpServletRequest, String cookieName) {
        Cookie[] cookies = httpServletRequest.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)) {
                return cookie.getValue();
            }
        }
        return null;
    }

    public static boolean isAjaxRequest(HttpServletRequest httpServletRequest) {
        return "XMLHttpRequest".equals(httpServletRequest.getHeader("X-Requested-With"));
    }

    public static String getRequestUrl(HttpServletRequest request) {
        return request.getRequestURL() + (request.getQueryString() == null ? "" : "?" + request.getQueryString());
    }

    public static boolean isGetRequest(HttpServletRequest request){
        return request.getMethod().equalsIgnoreCase("get");
    }

    public static boolean isPostRequest(HttpServletRequest request){
        return request.getMethod().equalsIgnoreCase("post");
    }

    public static String encodeUrl(String url){
        try {
            return URLEncoder.encode(url, "UTF-8");
        }catch (Throwable t){
            throw new RuntimeException(t);
        }
    }

    public static String encodeUrl(HttpServletRequest request){
        return encodeUrl(getRequestUrl(request));
    }

    public static String decodeUrl(){
        // TODO
        return "";
    }
}
