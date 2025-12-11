package dev.ofelipexis.bookstore.author;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDateTime;
@JsonPropertyOrder({"id", "name", "email", "description", "createdAt"})
public class AuthorResponse {

    private Long id;
    private String name;
    private String email;
    private String description;
    private LocalDateTime createdAt;

    public AuthorResponse(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.email = author.getEmail();
        this.description = author.getDescription();
        this.createdAt = author.getCreatedAt();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "AuthorResponse{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
