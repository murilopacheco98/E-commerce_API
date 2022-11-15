package com.ecommerce.educative.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ecommerce.educative.exception.customExceptions.AutheticationFailExeception;
import com.ecommerce.educative.exception.customExceptions.BadRequestException;
import com.ecommerce.educative.exception.customExceptions.ForbiddenException;
import com.ecommerce.educative.exception.customExceptions.InternalServerErrorException;
import com.ecommerce.educative.exception.customExceptions.NotFoundException;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(value = BadRequestException.class)
    public final ResponseEntity<StandardError> handleBadRequestException(BadRequestException exception, HttpServletRequest request) {
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setError("Resource not found.");
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(value = AutheticationFailExeception.class)
    public final ResponseEntity<StandardError> handleAutheticationFailException(AutheticationFailExeception exeception, HttpServletRequest request) {
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.UNAUTHORIZED.value());
        error.setError("You are not authorized from taking this action.");
        error.setMessage(exeception.getMessage());
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public final ResponseEntity<StandardError> handleNotFoundException(NotFoundException exeception, HttpServletRequest request) {
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError("Resource not found.");
        error.setMessage(exeception.getMessage());
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(value = InternalServerErrorException.class)
    public final ResponseEntity<StandardError> handleInternalServerErrorException(InternalServerErrorException exeception, HttpServletRequest request) {
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setError("Internal server error.");
        error.setMessage(exeception.getMessage());
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(value = ForbiddenException.class)
    public final ResponseEntity<StandardError> handleForbiddenException(ForbiddenException exeception, HttpServletRequest request) {
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.FORBIDDEN.value());
        error.setError("You are prohibited from taking this action.");
        error.setMessage(exeception.getMessage());
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
    }
}
