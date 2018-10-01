package boying.dao.book.mapper;

import boying.domain.book.Pic;

public interface PicMapper {
    int insert(Pic record);

    int insertSelective(Pic record);

    Pic selectByPrimaryKey(Long id);
}