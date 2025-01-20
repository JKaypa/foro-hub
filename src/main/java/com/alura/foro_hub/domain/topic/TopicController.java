package com.alura.foro_hub.domain.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.foro_hub.dto.topic.TopicRequestDto;
import com.alura.foro_hub.dto.topic.TopicResponseDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("topic")
public class TopicController {

  @Autowired
  TopicService topicService;

  @PostMapping
  public ResponseEntity<TopicResponseDto> createTopic(@RequestBody @Valid TopicRequestDto topicRequest){
    return ResponseEntity.status(HttpStatus.CREATED).body(topicService.createTopic(topicRequest));
  }

}
