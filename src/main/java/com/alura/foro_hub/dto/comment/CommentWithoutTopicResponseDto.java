package com.alura.foro_hub.dto.comment;

import java.time.LocalDateTime;

import com.alura.foro_hub.domain.comment.Comment;
import com.alura.foro_hub.dto.user.UserResponseDto;

public record CommentWithoutTopicResponseDto(
    Long id,
    String message,
    UserResponseDto author,
    LocalDateTime createdAt) {
  public CommentWithoutTopicResponseDto(Comment comment) {
    this(comment.getId(), comment.getMessage(), new UserResponseDto(comment.getAuthor()),
        comment.getCreatedAt());
  }
}
