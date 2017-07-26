package boying.controller;

import boying.domain.book.Book;
import boying.form.BookForm;
import boying.response.BaseResponse;
import boying.response.ErrorCode;
import boying.service.book.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by boying on 2017/7/21.
 */
@RestController
@RequestMapping("/book")
public class BookController {
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    /**
     * curl -X POST \
     http://localhost:8080/book \
     -H 'cache-control: no-cache' \
     -H 'content-type: application/json' \
     -d '{"name": "name1234", "isbn": "fdsafs"}'
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse addBook(@RequestBody  BookForm bookForm) {
        logger.info("BookController#addBook into, form is {}", bookForm);

        Book book = new Book();
        book.setName(bookForm.getName());
        book.setIsbn(bookForm.getIsbn());
        try {
            bookService.addBook(book);
        } catch (Throwable t) {
            logger.error("create book failed, ", t);
            return BaseResponse.buildResponse(ErrorCode.BOOK_CREATE_BOOK_FAILED);
        }

        return BaseResponse.success(book);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse deleteBook(@PathVariable("id") long id) {
        logger.info("BookController#deleteBook into, id is {}", id);
        bookService.deleteBook(id);
        return BaseResponse.success();
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse updateBook(@PathVariable("id") long id, @RequestBody BookForm bookForm) {
        Book book = bookService.getBookById(id);
        if(book == null){
            return BaseResponse.buildResponse(ErrorCode.BOOK_NOT_FOUND);
        }

        book.setName(bookForm.getName());
        book.setIsbn(bookForm.getIsbn());
        bookService.updateBook(book);
        return BaseResponse.success(book);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse getBook(@PathVariable("id") long id) {
        Book book = bookService.getBookById(id);
        return BaseResponse.success(book);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public BaseResponse fuzzyQueryBook(@RequestParam("name") String name) {
        List<Book> books = bookService.fuzzyQueryBooksByName(name);
        return BaseResponse.success(books);
    }

}
