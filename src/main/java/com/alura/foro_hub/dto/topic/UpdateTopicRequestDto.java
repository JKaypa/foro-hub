package com.alura.foro_hub.dto.topic;

import com.alura.foro_hub.domain.topic.Status;

public record UpdateTopicRequestDto(
  String title,
  String description,
  Status status
) {

}
