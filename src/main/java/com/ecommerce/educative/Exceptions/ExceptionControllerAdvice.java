package com.ecommerce.educative.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(value = CustomException.class)
    public final ResponseEntity<String> handleCustomException(CustomException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = AutheticationFailExeception.class)
    public final ResponseEntity<String> handleAutheticationFailException(AutheticationFailExeception exeception) {
        return new ResponseEntity<>(exeception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ProductNotExistsException.class)
    public final ResponseEntity<String> handleProductNotExistsException(ProductNotExistsException exeception) {
        return new ResponseEntity<>(exeception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
