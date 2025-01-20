package com.alura.foro_hub.infra.error;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alura.foro_hub.dto.error.ErrorMapper;

@RestControllerAdvice
public class ErrorHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List<ErrorMapper>> handleMethodArgumentNotValidException(
      MethodArgumentNotValidException exception) {
    var errors = exception.getFieldErrors()
        .stream()
        .map(error -> new ErrorMapper(error.getField(), error.getDefaultMessage()))
        .toList();

    return ResponseEntity.badRequest().body(errors);
  }

  @ExceptionHandler(AuthException.class)
  public ResponseEntity<String> handleUnAuthenticatedUserException(AuthException error){
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error.getMessage());
  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<String> handleNotFoundException(NotFoundException error){
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
  }

}
