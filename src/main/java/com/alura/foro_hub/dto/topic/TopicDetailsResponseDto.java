package com.alura.foro_hub.dto.topic;

import java.time.LocalDateTime;
import java.util.List;

import com.alura.foro_hub.domain.topic.Topic;
import com.alura.foro_hub.dto.comment.CommentWithoutTopicResponseDto;
import com.alura.foro_hub.dto.user.UserResponseDto;

public record TopicDetailsResponseDto(
    Long id,
    String title,
    String description,
    UserResponseDto author,
    String status,
    LocalDateTime createdAt,
    List<CommentWithoutTopicResponseDto> comments) {
  public TopicDetailsResponseDto(Topic topic) {
    this(
        topic.getId(),
        topic.getTitle(),
        topic.getDescription(),
        new UserResponseDto(topic.getAuthor()),
        topic.getStatus().toString(),
        topic.getCreatedAt(),
        topic.getComments().stream().map(CommentWithoutTopicResponseDto::new).toList());
  }
}
