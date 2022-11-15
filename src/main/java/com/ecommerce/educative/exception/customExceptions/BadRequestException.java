package com.ecommerce.educative.exception.customExceptions;

public class BadRequestException extends IllegalArgumentException {

    public BadRequestException(String message) {
        super(message);
    }
}
