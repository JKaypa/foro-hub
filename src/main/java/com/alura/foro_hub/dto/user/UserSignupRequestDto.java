package com.alura.foro_hub.dto.user;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserSignupRequestDto(
  @NotBlank(message = "name should not be empty")
  @Size(min = 3, message = "name should have at least 3 characters")
  String name,

  @NotBlank(message = "email should not be empty")
  @Email
  String email,

  @NotBlank(message = "password should not be empty")
  @Size(min = 8, message = "password should have at least 8 characters")
  String password
) {

}
