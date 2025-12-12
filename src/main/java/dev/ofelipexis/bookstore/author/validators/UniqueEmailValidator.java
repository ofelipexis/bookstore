package dev.ofelipexis.bookstore.author.validators;

import dev.ofelipexis.bookstore.author.Author;
import dev.ofelipexis.bookstore.author.AuthorRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private AuthorRepository repository;

    public UniqueEmailValidator(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;

        Optional<Author> possibleAuthor = repository.findByEmail(value);

        return possibleAuthor.isEmpty();
    }
}
