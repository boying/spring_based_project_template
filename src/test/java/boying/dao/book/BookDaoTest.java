package boying.dao.book;

import boying.BaseTest;
import boying.domain.book.Book;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Created by boying on 2017/7/5.
 */

@Transactional("txManager")
public class BookDaoTest extends BaseTest {
    @Autowired
    private BookDao bookDao;

    @Test
    public void addAndGetTest() {
        Book book = new Book();
        book.setName("a book");
        book.setIsbn("isbnxxx");
        book.setCreated_at(Timestamp.valueOf(LocalDateTime.now()));
        book.setUpdated_at(Timestamp.valueOf(LocalDateTime.now()));
        bookDao.addBook(book);

        long id = book.getId();
        Assert.assertTrue(id > 0);

        Book getBook = bookDao.getBookById(id);
        Assert.assertTrue(book.getName().equals(getBook.getName())
                && book.getIsbn().equals(getBook.getIsbn()));
    }

}
