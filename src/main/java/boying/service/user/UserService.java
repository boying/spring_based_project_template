package boying.service.user;

import boying.dao.user.UserDao;
import boying.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by boying on 2017/7/4.
 */
@Service
public class UserService {
    @Value("${datasource.driverClassName}")
    public String name;

    @Autowired
    private UserDao userDao;

    public void addUser(User user){
        userDao.addUser(user);
    }

    public User getUser(long userId){
        return userDao.getUserById(userId);
    }
}
