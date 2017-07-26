package boying.service.book;

import boying.BaseTest;
import boying.domain.book.Book;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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
        bookService.addBook(book);

        Assert.assertTrue(book.getId() > 0);
    }

    @Test
    public void deleteBookTest() {
        Book book = new Book();
        book.setName("name");
        book.setIsbn("isbn");
        bookService.addBook(book);
        bookService.deleteBook(book.getId());
        book = bookService.getBookById(book.getId());
        Assert.assertEquals(book.getIs_delete(), 1);
    }

    @Test
    public void updateBookTest() {
        Book book = new Book();
        book.setName("name");
        book.setIsbn("isbn");
        bookService.addBook(book);

        String newName = "newName";
        String newIsbn = "newIsnb";
        book.setName(newName);
        book.setIsbn(newIsbn);
        bookService.updateBook(book);

        book = bookService.getBookById(book.getId());

        Assert.assertEquals(newName, book.getName());
        Assert.assertEquals(newIsbn, book.getIsbn());
    }

    @Test
    public void fuzzyQueryBooksByName() {
        Book book = new Book();
        book.setName("xfuzzyQueryBooksByName1");
        book.setIsbn("isbn");
        bookService.addBook(book);
        book.setName("xfuzzyQueryBooksByName2");
        bookService.addBook(book);

        List<Book> books = bookService.fuzzyQueryBooksByName("fuzzyQueryBooksByName");
        Assert.assertNotNull(books);
        Assert.assertEquals(books.size(), 2);
    }

}
