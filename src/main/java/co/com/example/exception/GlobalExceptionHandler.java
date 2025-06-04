package co.com.example.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final String TAG_STATUS = "status";
    private static final String TAG_ERROR = "error";
    private static final String TAG_MESSAGE = "message";

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(ConstraintViolationException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put(TAG_STATUS, HttpStatus.CONFLICT.value());
        response.put(TAG_ERROR, "Conflict");

        List<Map<String, String>> errors = ex.getConstraintViolations().stream()
            .map(violation -> Map.of(
                "field", violation.getPropertyPath().toString(),
                TAG_MESSAGE, violation.getMessage()))
            .toList();

        response.put("errors", errors);

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String, String>> handleMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        Map<String, String> response = new HashMap<>();
        response.put(TAG_STATUS, HttpStatus.METHOD_NOT_ALLOWED.toString());
        response.put(TAG_ERROR, "Method Not Allowed");
        response.put(TAG_MESSAGE, ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoResourceFoundException(NoResourceFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put(TAG_STATUS, HttpStatus.NOT_FOUND.toString());
        response.put(TAG_ERROR, "Not Found");
        response.put(TAG_MESSAGE, ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}