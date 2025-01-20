package com.alura.foro_hub.infra.error;

public class AuthException extends RuntimeException {
  public AuthException(String message){
    super(message);
  }
}
