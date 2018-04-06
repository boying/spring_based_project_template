package boying.service.user

import boying.SpringSpec
import boying.domain.user.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.annotation.Rollback
import org.springframework.transaction.annotation.Transactional

import java.sql.Timestamp
import java.time.LocalDateTime

@Transactional("txManager1")
class UserServiceUt extends SpringSpec {
    @Autowired
    UserService userService

    @Rollback
    def addUserTest() {
        User user = new User()
        user.setName("haha")
        user.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()))
        user.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()))
        userService.addUser(user);

        expect:
        user.getId() > 0
    }

}
