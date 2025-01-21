package com.alura.foro_hub.domain.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.foro_hub.dto.topic.TopicDetailsResponseDto;
import com.alura.foro_hub.dto.topic.TopicRequestDto;
import com.alura.foro_hub.dto.topic.TopicResponseDto;
import com.alura.foro_hub.dto.topic.UpdateTopicRequestDto;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("topic")
@SecurityRequirement(name = "bearer-key")
public class TopicController {

  @Autowired
  TopicService topicService;

  @PostMapping
  public ResponseEntity<TopicResponseDto> createTopic(@RequestBody @Valid TopicRequestDto topicRequest) {
    return ResponseEntity.status(HttpStatus.CREATED).body(topicService.createTopic(topicRequest));
  }

  @GetMapping
  public Page<TopicResponseDto> listTopics(
      @PageableDefault(sort = "createdAt", direction = Direction.ASC) Pageable pageable) {
    return topicService.getAllTopics(pageable);

  }

  @GetMapping("/{id}")
  public ResponseEntity<TopicDetailsResponseDto> getTopic(@PathVariable Long id) {
    return ResponseEntity.ok(topicService.getTopic(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<TopicResponseDto> editTopic(@PathVariable Long id, @RequestBody UpdateTopicRequestDto updateTopic) {
    return ResponseEntity.ok(topicService.updateTopic(updateTopic, id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteTopic(@PathVariable Long id) {
    return ResponseEntity.ok(topicService.deleteTopic(id));
  }

}
