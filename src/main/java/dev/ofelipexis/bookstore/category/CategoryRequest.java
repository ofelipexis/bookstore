package dev.ofelipexis.bookstore.category;

import dev.ofelipexis.bookstore.shared.validators.UniqueValue;
import jakarta.validation.constraints.NotBlank;

public class CategoryRequest {

    @NotBlank(message = "Nome não pode estar em branco")
    @UniqueValue(fieldName = "name", domainClass = Category.class, message = "Nome de Categoria já cadastrado")
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
