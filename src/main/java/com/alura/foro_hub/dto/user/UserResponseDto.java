package com.alura.foro_hub.dto.user;

import com.alura.foro_hub.domain.user.User;

public record UserResponseDto(
    Long id,
    String name,
    String email) {
  public UserResponseDto(User user) {
    this(user.getId(), user.getName(), user.getEmail());
  }
}
