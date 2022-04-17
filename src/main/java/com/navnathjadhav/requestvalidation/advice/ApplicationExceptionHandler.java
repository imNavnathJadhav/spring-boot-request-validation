package com.navnathjadhav.requestvalidation.advice;

import com.navnathjadhav.requestvalidation.exception.SaveFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleInvalidMethodArgumentException(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
    }

    @ExceptionHandler(SaveFailedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> handleSaveFailedException(SaveFailedException ex) {
        return Map.of("errorMessage", ex.getMessage());
    }
}
