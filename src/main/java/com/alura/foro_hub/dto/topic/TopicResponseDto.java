package com.alura.foro_hub.dto.topic;

import java.time.LocalDateTime;

import com.alura.foro_hub.domain.topic.Topic;
import com.alura.foro_hub.dto.user.UserResponseDto;

public record TopicResponseDto(
    Long id,
    String title,
    String description,
    UserResponseDto author,
    String status,
    LocalDateTime createdAt) {
  public TopicResponseDto(Topic topic) {
    this(
        topic.getId(),
        topic.getTitle(),
        topic.getDescription(),
        new UserResponseDto(topic.getAuthor()),
        topic.getStatus().toString(),
        topic.getCreatedAt());
  }
}
