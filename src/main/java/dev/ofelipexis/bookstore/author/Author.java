package dev.ofelipexis.bookstore.author;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    @Size(max = 400)
    private String description;
    private LocalDateTime createdAt = LocalDateTime.now();

    @Deprecated
    public Author() {
    }

    public Author(@NotBlank String name, @NotBlank @Email String email, @Size(max = 400) String description) {
        this.name = name;
        this.email = email;
        this.description = description;
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
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
