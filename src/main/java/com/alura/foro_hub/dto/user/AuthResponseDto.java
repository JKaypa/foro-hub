package com.alura.foro_hub.dto.user;

import com.alura.foro_hub.domain.user.User;

public record AuthResponseDto(Long id, String name, String email, String token) {
public AuthResponseDto(User user, String token){
  this(user.getId(), user.getName(), user.getEmail(), token);
}
}
