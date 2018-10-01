package boying.dao.book.mapper;

import boying.domain.book.Book;

public interface BookMapper {
    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Long id);
}