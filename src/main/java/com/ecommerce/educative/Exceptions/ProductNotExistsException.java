package com.ecommerce.educative.Exceptions;

public class ProductNotExistsException extends IllegalArgumentException{
    public ProductNotExistsException(String message) {
        super(message);
    }
}
