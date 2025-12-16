package dev.ofelipexis.bookstore.book.detail;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import dev.ofelipexis.bookstore.book.Book;

import java.math.BigDecimal;
import java.time.LocalDate;

@JsonPropertyOrder({"id", "title", "summary", "tableOfContents", "price", "numberOfPages", "isbn", "releaseDate", "author"})
public class BookDetailResponse {

    private Long id;
    private String title;
    private String summary;
    private String tableOfContents;
    private BigDecimal price;
    private Integer numberOfPages;
    private String isbn;
    private LocalDate releaseDate;
    private BookAuthorDetailResponse author;

    public BookDetailResponse(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.summary = book.getSummary();
        this.tableOfContents = book.getTableOfContents();
        this.price = book.getPrice();
        this.numberOfPages = book.getNumberOfPages();
        this.isbn = book.getIsbn();
        this.releaseDate = book.getReleaseDate();
        this.author = new BookAuthorDetailResponse(book.getAuthor());
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

    public BookAuthorDetailResponse getAuthor() {
        return author;
    }
}
