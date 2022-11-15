package com.ecommerce.educative.exception.customExceptions;

public class InternalServerErrorException extends IllegalArgumentException{
    public InternalServerErrorException(String message) {
        super(message);
    }
}
