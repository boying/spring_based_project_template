package boying.service.book;

import boying.BaseTest;
import boying.dao.book.BookDao;
import boying.domain.book.Book;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by boying on 2017/7/6.
 */
@Transactional("txManager")
public class BookServiceMockTest extends BaseTest {
    /**
     * BookServiceMockTest对象中的bookService并非boying.service.book.BookService类的对象，而是它子类的对象。子类对象代理
     * 了真正的boying.service.book.BookService对象。
     *
     * bookDaoMock会被设置到bookService的成员bookDao
     *
     * 如果boying.service.book.BookService有bookDao的setter，Mockito将会调用setter设置bookDao，否则，类似于直接赋值
     *
     * setter方式，bookService最终会调用被代理的boying.service.book.BookService对象里setter方法，被代理对象属性bookDao将设置为bookDaoMock
     *
     * 赋值方式，bookService的属性bookDao会被赋值为bookDaoMock，但被代理的boying.service.book.BookService里的bookDao属性仍然是spring容器中的dao。
     * 因此调用bookService的业务方法时，真正工作的dao并非bookDaoMock对象，所以mock的行为将失效
     *
     * 所以，如果希望Mockito mock spring容器中某对象的属性，需要为该属性添加setter
     *
     * 注意！！！
     * 当你将spring容器中某对象的属性设置为mock对象后，该属性会一直是mock对象，因而可能会影响其他测试用例（因为其他测试用例使用的是spring中对象，它
     * 认为spring中对象的属性不是mock的，而实际上却是是mock的）。所以，在ut方法结束后，需要将spring对象属性设置为原来的，保证不影响其他case
     */
    //@InjectMocks
    @Autowired
    private BookService bookService;

    @Mock
    private BookDao bookDaoMock;

    @Test
    public void getBookByIdTest(){
        BookDao originBookDao = bookService.getBookDao();
        try {
            bookService.setBookDao(bookDaoMock);

            long bookId = 3;
            Book book = new Book();
            Mockito.when(bookDaoMock.getBookById(Mockito.anyLong())).thenReturn(book);
            Book bookById = bookService.getBookById(bookId);
            Assert.assertSame(book, bookById);
        }finally {
            bookService.setBookDao(originBookDao);
        }
    }

}
