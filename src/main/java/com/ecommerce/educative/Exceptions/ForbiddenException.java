package com.ecommerce.educative.Exceptions;

public class ForbiddenException extends IllegalArgumentException {
  public ForbiddenException(String message) {
    super(message);
  }
}
