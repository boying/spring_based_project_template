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
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

/**
 * Created by boying on 2017/7/4.
 */
@Service
public class App {

    public int add(int a, int b){
        return a + b;
    }
}
