package dev.ofelipexis.bookstore.category;

import dev.ofelipexis.bookstore.category.validators.UniqueName;
import jakarta.validation.constraints.NotBlank;

public class CategoryRequest {

    @NotBlank(message = "Nome não pode estar em branco")
    @UniqueName(message = "Nome já cadastrado")
    private String name;

    public CategoryRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Category toModel() {
        return new Category(this.name);
    }
}
