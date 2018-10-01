package boying.dao.user;

import boying.dao.user.mapper.UserMapper;
import boying.domain.user.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by boying on 2017/7/4.
 */
public interface UserDao extends UserMapper {
    User getUserByName(@Param("name") String name);
}
