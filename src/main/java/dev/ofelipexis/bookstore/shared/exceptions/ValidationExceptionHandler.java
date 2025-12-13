package dev.ofelipexis.bookstore.shared.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {
        List<ValidationErrorDetail> messages = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> new ValidationErrorDetail(x.getField(), x.getDefaultMessage()))
                .toList();

        ValidationErrorResponse validationErrorResponse = new ValidationErrorResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                messages
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationErrorResponse);
    }
}
