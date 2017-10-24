package boying.dto.user;

import lombok.Data;

/**
 * Created by boying on 2017/10/19.
 */
@Data
public class LoginResult {
    private boolean loginSuccess;
    private String sessionId;
    private int code;
    private String msg;

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
}
