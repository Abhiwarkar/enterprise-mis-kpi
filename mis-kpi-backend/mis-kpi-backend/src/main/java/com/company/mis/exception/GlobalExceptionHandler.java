package com.company.mis.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiError> handleBusiness(BusinessException ex, HttpServletRequest req) {
        return ResponseEntity.badRequest().body(
                ApiError.builder()
                        .timestamp(LocalDateTime.now())
                        .status(400)
                        .error(ex.getMessage())
                        .path(req.getRequestURI())
                        .build()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException ex,
                                                     HttpServletRequest req) {
        return ResponseEntity.badRequest().body(
                ApiError.builder()
                        .timestamp(LocalDateTime.now())
                        .status(400)
                        .error("Validation failed")
                        .path(req.getRequestURI())
                        .build()
        );
    }
}
