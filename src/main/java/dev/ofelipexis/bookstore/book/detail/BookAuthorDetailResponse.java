package dev.ofelipexis.bookstore.book.detail;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import dev.ofelipexis.bookstore.author.Author;

@JsonPropertyOrder({"id", "name", "description"})
public class BookAuthorDetailResponse {

    private Long id;
    private String name;
    private String description;

    public BookAuthorDetailResponse(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.description = author.getDescription();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
