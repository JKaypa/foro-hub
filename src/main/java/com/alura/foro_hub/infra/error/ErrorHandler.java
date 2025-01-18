package com.alura.foro_hub.infra.error;

import java.util.List;

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

}
