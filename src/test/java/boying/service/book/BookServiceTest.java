package boying.service.book;

import boying.BaseTest;
import boying.domain.book.Book;
import boying.domain.enums.BoolType;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by boying on 2017/7/6.
 */
@Transactional("txManager")
public class BookServiceTest extends BaseTest {
    @Autowired
    private BookService bookService;

    @Test
    public void addBookTest() {
        Book book = new Book();
        book.setName("name");
        book.setIsbn("isbn");
        book.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        book.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        bookService.addBook(book);

        Class<? extends BookService> aClass = bookService.getClass();
        System.out.println(aClass);

        Class<? extends BookService> aClass1 = bookService.self().getClass();
        System.out.println(aClass1);

        Assert.assertTrue(aClass == aClass1);

        Assert.assertTrue(book.getId() > 0);
    }

    @Test
    public void deleteBookTest() {
        Book book = new Book();
        book.setName("name");
        book.setIsbn("isbn");
        book.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        book.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        bookService.addBook(book);
        bookService.deleteBook(book.getId());
        book = bookService.getBookById(book.getId());
        Assert.assertEquals(book.getIsDelete(), BoolType.TRUE);
    }

    @Test
    public void updateBookTest() {
        Book book = new Book();
        book.setName("name");
        book.setIsbn("isbn");
        book.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        book.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        bookService.addBook(book);

        String newName = "newName";
        String newIsbn = "newIsnb";
        book.setName(newName);
        book.setIsbn(newIsbn);
        bookService.updateBook(book);

        book = bookService.getBookById(book.getId());

        Assert.assertEquals(book, book);
    }

    @Test
    public void fuzzyQueryBooksByName() {
        Book book = new Book();
        book.setName("xfuzzyQueryBooksByName1");
        book.setIsbn("isbn");
        book.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        book.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));

        bookService.addBook(book);
        book.setName("xfuzzyQueryBooksByName2");
        bookService.addBook(book);

        List<Book> books = bookService.fuzzyQueryBooksByName("fuzzyQueryBooksByName");
        Assert.assertNotNull(books);
        Assert.assertEquals(books.size(), 2);
    }

}
