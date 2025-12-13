package dev.ofelipexis.bookstore.author;

import dev.ofelipexis.bookstore.shared.validators.UniqueValue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AuthorRequest {

    @NotBlank(message = "Nome não pode estar em branco")
    private String name;
    @NotBlank(message = "E-mail não pode estar em branco")
    @Email(message = "E-mail deve estar em um formato válido")
    @UniqueValue(fieldName = "email", domainClass = Author.class, message = "E-mail de Autor já cadastrado")
    private String email;
    @Size(max = 400, message = "Descrição deve ter no máximo 400 caracteres")
    private String description;

    public AuthorRequest(String description, String email, String name) {
        this.description = description;
        this.email = email;
        this.name = name;
    }

    public Author toModel() {
        return new Author(this.name, this.email, this.description);
    }
}
