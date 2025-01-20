package com.alura.foro_hub.dto.comment;

import java.time.LocalDateTime;

import com.alura.foro_hub.domain.comment.Comment;
import com.alura.foro_hub.dto.topic.TopicResponseDto;
import com.alura.foro_hub.dto.user.UserResponseDto;

public record CommentResponseDto(
    Long id,
    String message,
    UserResponseDto author,
    TopicResponseDto topic,
    LocalDateTime createdAt) {
  public CommentResponseDto(Comment comment) {
    this(comment.getId(), comment.getMessage(), new UserResponseDto(comment.getAuthor()),
        new TopicResponseDto(comment.getTopic()),
        comment.getCreatedAt());
  }
}
