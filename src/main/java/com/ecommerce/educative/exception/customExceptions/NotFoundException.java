package com.ecommerce.educative.exception.customExceptions;

public class NotFoundException extends IllegalArgumentException{
    public NotFoundException(String message) {
        super(message);
    }
}
