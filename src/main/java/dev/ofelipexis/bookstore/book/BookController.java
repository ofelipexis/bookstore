package dev.ofelipexis.bookstore.book;

import dev.ofelipexis.bookstore.author.Author;
import dev.ofelipexis.bookstore.category.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class BookController {

    private BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/books")
    @Transactional
    public ResponseEntity<BookResponse> create(@RequestBody @Valid BookRequest request) {
        Book book = request.toModel(
                id -> manager.find(Category.class, id),
                id -> manager.find(Author.class, id)
        );
        repository.save(book);
        return ResponseEntity.ok().body(new BookResponse(book));
    }
}
