package dev.ofelipexis.bookstore.book.detail;

import dev.ofelipexis.bookstore.book.Book;
import dev.ofelipexis.bookstore.book.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/api/v1")
public class BookDetailController {

    private BookRepository repository;

    public BookDetailController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/books/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<BookDetailResponse> findById(@PathVariable("id") Long id) {
        Book book = repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND)
        );

        return ResponseEntity.ok().body(new BookDetailResponse(book));
    }
}
