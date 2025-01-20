package com.alura.foro_hub.infra.error;

public class NotFoundException extends RuntimeException {
  public NotFoundException(String message){
    super(message);
  }
}
