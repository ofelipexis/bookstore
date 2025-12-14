package dev.ofelipexis.bookstore.shared.validators;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.Assert;

import java.util.List;

public class IdExistsValidator implements ConstraintValidator<IdExists, Object> {

    private String domainAttribute;
    private Class<?> clazz;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(IdExists constraintAnnotation) {
        this.domainAttribute = constraintAnnotation.fieldName();
        this.clazz = constraintAnnotation.domainClass();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        Query query = manager.createQuery(
                "SELECT 1 FROM "
                + clazz.getName()
                + " WHERE "
                + domainAttribute
                + "=:VALUE"
        );
        query.setParameter("VALUE", value);

        List<?> result = query.getResultList();

        Assert.state(
                result.size() <= 1,
                "Foi encontrado mais de um " + clazz + " com o atributo " + domainAttribute + " = " + value
        );

        return !result.isEmpty();
    }
}
