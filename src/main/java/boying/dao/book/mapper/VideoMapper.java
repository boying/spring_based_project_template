package boying.dao.book.mapper;

import boying.domain.book.Video;

public interface VideoMapper {
    int insert(Video record);

    int insertSelective(Video record);

    Video selectByPrimaryKey(Long id);
}