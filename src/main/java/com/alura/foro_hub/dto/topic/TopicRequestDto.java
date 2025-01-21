package com.alura.foro_hub.dto.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicRequestDto(
  @NotBlank(message = "title should not be empty")
  String title,

  @NotBlank(message = "description should not be empty")
  String description, 

  @NotNull(message = "author should not be empty")
  Long author
) {

}
