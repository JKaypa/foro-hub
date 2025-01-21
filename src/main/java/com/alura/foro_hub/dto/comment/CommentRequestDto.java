package com.alura.foro_hub.dto.comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CommentRequestDto(
        @NotBlank(message = "message should not be empty") String message,

        @NotNull(message = "topic should not be empty") Long topic,

        @NotNull(message = "author should not be empty") Long author) {

}
