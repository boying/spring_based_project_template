package boying;

import boying.dao.book.BookDao;
import boying.dao.user.UserDao;
import boying.domain.book.Book;
import boying.domain.book.Pic;
import boying.domain.user.User;
import boying.service.book.BookService;
import boying.service.book.PicService;
import boying.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

/**
 * Created by boying on 2017/7/4.
 */
@Service
public class App {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private BookService bookService;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;
    @Autowired
    private PicService picService;

    public static void main2(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        App app = context.getBean(App.class);
        //app.dao();
        //app.bookService();
        //app.userService();
        //app.picService();
        //app.log();
        //app.sleep();
        //System.out.println(app.name);


    }

    public static void main(String[] args) {
        Pattern pattern1 = Pattern.compile("/book");
        Pattern pattern2 = Pattern.compile("/book/\\d+");

        System.out.println(pattern1.matcher("/book").matches());
        System.out.println(pattern1.matcher("/book/123").matches());

        System.out.println(pattern2.matcher("/book").matches());
        System.out.println(pattern2.matcher("/book/123").matches());
    }

    public void log() {
        picService.log();
    }

    public void sleep() {
        try {
            while (true) {
                Thread.sleep(10000);
            }
        } catch (Throwable t) {

        }

    }

    public void picService() {
        Pic pic = new Pic();
        pic.setName("hahaha");
        picService.addPic(pic);
    }

    public void bookService() {
        Book b = new Book();
        b.setId(888);
        b.setName("haha");
        b.setIsbn("isbn");
        bookService.addBook(b);
        System.out.println(b);

    }

    public void userService() {
        User user = new User();
        user.setName("haah");
        userService.addUser(user);
        System.out.println(user);
    }

    public void dao() {
        Book b = new Book();
        b.setName("book2");
        b.setIsbn("fsfsfa");
    }
}
