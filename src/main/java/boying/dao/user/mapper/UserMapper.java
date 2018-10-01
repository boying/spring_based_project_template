package boying.dao.user.mapper;

import boying.domain.user.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);
}