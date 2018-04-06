package boying.service.book

import boying.SpringSpec
import boying.domain.book.Book
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.annotation.Rollback
import org.springframework.transaction.annotation.Transactional

import java.sql.Timestamp
import java.time.LocalDateTime

@Transactional("txManager")
class BookServiceUt extends SpringSpec {
    @Autowired
    BookService bookService

    @Rollback
    def "addBookTest"() {
        Book book = new Book(name: "name",
                isbn: "isbn",
                phoneNumber: "32423423",
                createdAt: Timestamp.valueOf(LocalDateTime.now()),
                updatedAt: Timestamp.valueOf(LocalDateTime.now()))
        bookService.addBook(book)

        expect:
        book.getId() > 0
    }

    def "deleteBookTest"() {
        Book book = new Book(name: "name",
                isbn: "isbn",
                phoneNumber: "32423423",
                createdAt: Timestamp.valueOf(LocalDateTime.now()),
                updatedAt: Timestamp.valueOf(LocalDateTime.now()))
        bookService.addBook(book)
        bookService.deleteBook(book.getId())
        book = bookService.getBookById(book.getId())

        expect:
        book.getIsDelete() == 1
    }

}
