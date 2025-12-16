package dev.ofelipexis.bookstore.book.list;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import dev.ofelipexis.bookstore.book.Book;

@JsonPropertyOrder({"id", "title"})
public class BookMinResponse {

    private Long id;
    private String title;

    public BookMinResponse(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
