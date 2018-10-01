package boying.service.user;

import boying.BaseTest;
import boying.domain.user.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Created by boying on 2017/7/6.
 */
@Transactional("txManager1")
public class UserServiceTest extends BaseTest {
    @Autowired
    private UserService userService;

    @Test
    public void addUserTest() {
        User user = new User();
        user.setName("haha");
        user.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        user.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        userService.addUser(user);

        Assert.assertTrue(user.getId() > 0);
    }

    @Test
    public void getUserTest() {
        User user = new User();
        user.setName("haha");
        user.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        user.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        userService.addUser(user);

        User getUser = userService.getUser(user.getId());

        Assert.assertNotNull(getUser);
    }

}
