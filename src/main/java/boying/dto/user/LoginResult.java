package boying.dto.user;

/**
 * Created by boying on 2017/10/19.
 */
public class LoginResult {
    private boolean loginSuccess;
    private String sessionId;

    public static LoginResult success(){
        LoginResult result = new LoginResult();
        result.setLoginSuccess(true);
        return result;
    }

    public static LoginResult failed(){
        LoginResult result = new LoginResult();
        result.setLoginSuccess(false);
        return result;
    }

    public boolean isLoginSuccess() {
        return loginSuccess;
    }

    public void setLoginSuccess(boolean loginSuccess) {
        this.loginSuccess = loginSuccess;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
