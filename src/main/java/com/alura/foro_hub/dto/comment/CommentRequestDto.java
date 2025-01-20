package com.alura.foro_hub.dto.comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CommentRequestDto(
    @NotBlank String message,

    @NotNull Long topic,

    @NotNull Long author) {

}
