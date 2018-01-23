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
        book.setPhoneNumber("479464646");
        book.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        book.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        bookDao.addBook(book);

        long id = book.getId();
        Assert.assertTrue(id > 0);

        Book getBook = bookDao.getBookById(id);
        Assert.assertEquals(book, getBook);
    }

    @Test
    public void updateNameByIdTest(){
        String newName = "name";
        int affectedRows = bookDao.updateNameById(newName, 123L);
        Assert.assertTrue(affectedRows == 0);

        Book book = new Book();
        book.setName("a book");
        book.setIsbn("isbnxxx");
        book.setPhoneNumber("479464646");
        book.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        book.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        bookDao.addBook(book);
        affectedRows = bookDao.updateNameById(newName, book.getId());
        Assert.assertTrue(affectedRows == 1);
        Book b = bookDao.getBookById(book.getId());
        Assert.assertEquals(b.getName(), newName);
    }

}
