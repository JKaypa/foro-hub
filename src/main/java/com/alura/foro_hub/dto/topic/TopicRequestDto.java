package com.alura.foro_hub.dto.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicRequestDto(
  @NotBlank
  String title,

  @NotBlank
  String description, 

  @NotNull
  Long author
) {

}
