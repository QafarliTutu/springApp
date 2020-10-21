package com.testApp.springApp.handler;

import com.testApp.springApp.exceptions.EmployeeNotFoundEx;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends DefaultErrorAttributes {

    private static final String ARGUMENT_VALIDATION_FAILED = "Argument validation failed";

//    @ExceptionHandler(value = IllegalArgumentException.class)
//    public ResponseEntity<Map<String, Object>> illegalArgumentException(IllegalArgumentException e, ServletWebRequest request) {
//        return ofType(request, HttpStatus.BAD_REQUEST, e.getMessage());
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public final ResponseEntity<Map<String, Object>> handle(MethodArgumentNotValidException ex, WebRequest request) {
//        List<ConstraintsViolationError> validationErrors = ex.getBindingResult()
//                .getFieldErrors()
//                .stream()
//                .map(error -> new ConstraintsViolationError(error.getField(), error.getDefaultMessage()))
//                .collect(Collectors.toList());
//        return ofType(request, HttpStatus.BAD_REQUEST, ARGUMENT_VALIDATION_FAILED, validationErrors);
//    }
//
//    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
//    public final ResponseEntity<Map<String, Object>> handle(MethodArgumentTypeMismatchException ex, WebRequest request) {
//        log.trace("Method  arguments are not valid {}", ex.getMessage());
//        return ofType(request, HttpStatus.BAD_REQUEST, ex.getMessage());
//    }
//
//    @ExceptionHandler(ConstraintViolationException.class)
//    public final ResponseEntity<Map<String, Object>> handle(ConstraintViolationException ex, WebRequest request) {
//        log.trace("Constraints violated {}", ex.getMessage());
//        return ofType(request, HttpStatus.BAD_REQUEST, getConstraintViolationExceptionMessage(ex));
//    }
//
//    @ExceptionHandler(InvalidStateException.class)
//    public ResponseEntity<Map<String, Object>> handle(InvalidStateException ex, WebRequest request) {
//        return ofType(request, HttpStatus.BAD_REQUEST, ex.getMessage());
//    }
//    private String getConstraintViolationExceptionMessage(ConstraintViolationException ex) {
//        return ex.getConstraintViolations()
//                .stream()
//                .map(ConstraintViolation::getMessage)
//                .collect(Collectors.toList()).get(0);
//    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String, Object>> handle(NotFoundException ex, WebRequest request) {
        return ofType(request, HttpStatus.NOT_FOUND, ex.getMessage());
    }

    private ResponseEntity<Map<String, Object>> ofType(WebRequest request, HttpStatus status, String message) {
       return ofType(request,status,message, Collections.EMPTY_LIST);
    }

    private ResponseEntity<Map<String, Object>> ofType(WebRequest request, HttpStatus status, String message, List validationErrors) {
        Map<String, Object> attributes = getErrorAttributes(request, ErrorAttributeOptions.defaults());
        attributes.put("status", status.value());
        attributes.put("error", status.getReasonPhrase());
        attributes.put("message", message);
        attributes.put("errors", validationErrors);
        attributes.put("path", ((ServletWebRequest) request).getRequest().getRequestURI());
        return new ResponseEntity<>(attributes, status);
    }

}
