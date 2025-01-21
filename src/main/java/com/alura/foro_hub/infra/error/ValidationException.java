package com.alura.foro_hub.infra.error;

public class ValidationException extends RuntimeException {
  public ValidationException(String message) {
    super(message);
  }
}
