package boying.dao.book;

import boying.dao.book.mapper.BookMapper;
import boying.domain.book.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by boying on 2017/7/4.
 */
public interface BookDao extends BookMapper{
    void deleteBook(@Param("id") long id);

    void updateBook(Book book);

    List<Book> fuzzyQueryBooksByName(@Param("name") String name);

    int updateNameById(@Param("name") String name, @Param("id") long id);
}
