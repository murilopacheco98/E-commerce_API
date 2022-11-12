package com.ecommerce.educative.Exceptions;

public class InternalServerErrorException extends IllegalArgumentException{
    public InternalServerErrorException(String message) {
        super(message);
    }
}
