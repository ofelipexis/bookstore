package dev.ofelipexis.bookstore.book;

import dev.ofelipexis.bookstore.author.Author;
import dev.ofelipexis.bookstore.category.Category;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String title;
    @NotBlank
    @Size(max = 500)
    private String summary;
    private String tableOfContents;
    @NotNull
    @Min(20)
    private BigDecimal price;
    @NotNull
    @Min(100)
    private Integer numberOfPages;
    @NotBlank
    @Column(unique = true)
    private String isbn;
    @NotNull
    @Future
    private LocalDate releaseDate;
    @ManyToOne
    @Valid
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    @ManyToOne
    @Valid
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @Deprecated
    public Book() {
    }

    public Book(String title, String summary, String tableOfContents, BigDecimal price, Integer numberOfPages, String isbn, LocalDate releaseDate, Category category, Author author) {
        this.title = title;
        this.summary = summary;
        this.tableOfContents = tableOfContents;
        this.price = price;
        this.numberOfPages = numberOfPages;
        this.isbn = isbn;
        this.releaseDate = releaseDate;
        this.category = category;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getTableOfContents() {
        return tableOfContents;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Category getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }
}
