package dev.ofelipexis.bookstore.category;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class CategoryController {

    private CategoryRepository repository;

    public CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/categories")
    @Transactional
    public ResponseEntity<CategoryResponse> create(@RequestBody @Valid CategoryRequest request) {
        Category category = request.toModel();
        repository.save(category);
        return ResponseEntity.ok().body(new CategoryResponse(category));
    }
}
