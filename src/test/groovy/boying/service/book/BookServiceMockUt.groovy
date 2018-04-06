package boying.service.book

import boying.dao.book.BookDao
import boying.domain.book.Book
import spock.lang.Specification

import java.sql.Timestamp
import java.time.LocalDateTime

class BookServiceMockUt extends Specification {
    BookService bookService
    BookDao bookDao = Mock(BookDao)

    def setup(){
        bookService = new BookService(bookDao: bookDao)
    }

    def "addBookTest"() {
        Book book = new Book(name: "name",
                isbn: "isbn",
                phoneNumber: "32423423",
                createdAt: Timestamp.valueOf(LocalDateTime.now()),
                updatedAt: Timestamp.valueOf(LocalDateTime.now()))
        when:
        bookService.addBook(book)

        then:
        bookDao.addBook(book) >> book.setId(1)
        book.getId() > 0
    }
}
