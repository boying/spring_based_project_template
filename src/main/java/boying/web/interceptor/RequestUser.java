package boying.web.interceptor;

import boying.domain.user.User;
import boying.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by boying on 2017/10/23.
 */
@Component
public class RequestUser {
    private ThreadLocal<User> userThreadLocal = new ThreadLocal<>();

    @Autowired
    private UserService userService;

    public void registerUser(Long userId){
        User user = userService.getUser(userId);
        if(user == null){
            throw new IllegalStateException("can't find user of id " + userId);
        }

        userThreadLocal.set(user);
    }

    public void unregisterUser(){
        userThreadLocal.remove();
    }


    public User getUser(){
        return userThreadLocal.get();
    }


}
