package com.alura.foro_hub.dto.comment;

import jakarta.validation.constraints.NotBlank;

public record UpdateCommentRequestDto(@NotBlank(message = "message should not be empty") String message) {

}
