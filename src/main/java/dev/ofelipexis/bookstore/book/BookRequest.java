package dev.ofelipexis.bookstore.book;

import dev.ofelipexis.bookstore.author.Author;
import dev.ofelipexis.bookstore.category.Category;
import dev.ofelipexis.bookstore.shared.validators.IdExists;
import dev.ofelipexis.bookstore.shared.validators.UniqueValue;
import jakarta.validation.constraints.*;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.function.Function;

public class BookRequest {

    @NotBlank(message = "Título é obrigatório")
    @UniqueValue(fieldName = "title", domainClass = Book.class, message = "Já existe um livro cadastrado com esse título")
    private String title;
    @NotBlank(message = "Resumo é obrigatório")
    @Size(max = 500, message = "Resumo deve ser de no máximo 500 caracteres")
    private String summary;
    @NotBlank(message = "Sumário é obrigatório")
    private String tableOfContents;
    @NotNull(message = "Preço é obrigatório")
    @Min(value = 20, message = "O preço mínimo deve ser 20")
    private BigDecimal price;
    @NotNull(message = "Número de páginas é obrigatório")
    @Min(value = 100, message = "O número mínimo de páginas deve ser 100")
    private Integer numberOfPages;
    @NotBlank(message = "ISBN é obrigatório")
    @UniqueValue(fieldName = "isbn", domainClass = Book.class, message = "Já existe um livro cadastrado com esse ISBN")
    private String isbn;
    @NotNull(message = "Data de lançamento é obrigatório")
    @Future(message = "Data de lançamento deve ser no futuro")
    private LocalDate releaseDate;
    @NotNull
    @IdExists(fieldName = "id", domainClass = Category.class, message = "Categoria não encontrada")
    private Long categoryId;
    @NotNull
    @IdExists(fieldName = "id", domainClass = Author.class, message = "Autor não encontrado")
    private Long authorId;

    public BookRequest(String title, String summary, String tableOfContents, BigDecimal price, Integer numberOfPages, String isbn, LocalDate releaseDate, Long categoryId, Long authorId) {
        this.title = title;
        this.summary = summary;
        this.tableOfContents = tableOfContents;
        this.price = price;
        this.numberOfPages = numberOfPages;
        this.isbn = isbn;
        this.releaseDate = releaseDate;
        this.categoryId = categoryId;
        this.authorId = authorId;
    }

    public Book toModel(Function<Long, Category> findCategory, Function<Long, Author> findAuthor) {
        @NotNull
        Category category = findCategory.apply(this.categoryId);
        @NotNull
        Author author = findAuthor.apply(this.authorId);

        Assert.state(Objects.nonNull(category), "Categoria não encontrada");
        Assert.state(Objects.nonNull(author), "Autor não encontrado");

        return new Book(this.title, this.summary, this.tableOfContents, this.price, this.numberOfPages,
                this.isbn,this.releaseDate, category, author);
    }
}
