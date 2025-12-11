package dev.ofelipexis.bookstore.author;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class AuthorController {

    AuthorRepository repository;

    public AuthorController(AuthorRepository repository) {
        this.repository = repository;
    }

    @PostMapping(value = "/authors")
    @Transactional
    public ResponseEntity<AuthorResponse> create(@RequestBody @Valid AuthorRequest request) {
        Author author = request.toModel();
        repository.save(author);
        return ResponseEntity.ok().body(new AuthorResponse(author));
    }
}
