package boying.service.user;

import boying.dao.user.UserDao;
import boying.domain.user.User;
import boying.dto.user.LoginParam;
import boying.dto.user.LoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by boying on 2017/10/19.
 */
@Service
public class LoginService {
    @Autowired
    private UserSessionService userSessionService;

    @Autowired
    private UserDao userDao;

    public LoginResult login(LoginParam loginParam){
        User user = userDao.getUserByName(loginParam.getName());
        if(user == null){
            return LoginResult.failed();
        }

        if(!user.getPassword().equals(loginParam.getPasswrod())){
            return LoginResult.failed();
        }

        String sessionId = userSessionService.createSessionId(user.getId());
        LoginResult result = new LoginResult();
        result.setLoginSuccess(true);
        result.setSessionId(sessionId);

        return result;
    }

}
