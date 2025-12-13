package dev.ofelipexis.bookstore.shared.exceptions;

public class ValidationErrorDetail {

    private String field;
    private String message;

    public ValidationErrorDetail(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
