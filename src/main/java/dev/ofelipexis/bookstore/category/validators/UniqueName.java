package dev.ofelipexis.bookstore.category.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueNameValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueName {
    String message() default "Category's name already exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
