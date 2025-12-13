package dev.ofelipexis.bookstore.category.validators;

import dev.ofelipexis.bookstore.category.Category;
import dev.ofelipexis.bookstore.category.CategoryRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {

    private CategoryRepository repository;

    public UniqueNameValidator(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void initialize(UniqueName constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;

        Optional<Category> possibleCategory = repository.findByName(value);

        return possibleCategory.isEmpty();
    }
}
