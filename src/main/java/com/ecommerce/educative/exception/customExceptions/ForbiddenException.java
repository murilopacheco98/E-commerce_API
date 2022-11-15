package com.ecommerce.educative.exception.customExceptions;

public class ForbiddenException extends IllegalArgumentException {
  public ForbiddenException(String message) {
    super(message);
  }
}
