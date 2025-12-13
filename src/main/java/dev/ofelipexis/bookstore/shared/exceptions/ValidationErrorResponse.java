package dev.ofelipexis.bookstore.shared.exceptions;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDateTime;
import java.util.List;

@JsonPropertyOrder({"timestamp", "status", "error", "details"})
public class ValidationErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private List<ValidationErrorDetail> details;

    public ValidationErrorResponse(LocalDateTime timestamp, int status, String error, List<ValidationErrorDetail> details) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public List<ValidationErrorDetail> getDetails() {
        return details;
    }
}
