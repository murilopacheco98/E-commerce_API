package com.ecommerce.educative.Exceptions;

public class NotFoundException extends IllegalArgumentException{
    public NotFoundException(String message) {
        super(message);
    }
}
