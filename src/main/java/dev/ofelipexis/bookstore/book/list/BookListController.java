package dev.ofelipexis.bookstore.book.list;

import dev.ofelipexis.bookstore.book.Book;
import dev.ofelipexis.bookstore.book.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class BookListController {

    private BookRepository repository;

    public BookListController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/books")
    @Transactional(readOnly = true)
    public ResponseEntity<List<BookMinResponse>> findAll() {
        List<Book> books = repository.findAll();
        return ResponseEntity.ok().body(books.stream().map(BookMinResponse::new).toList());
    }
}
