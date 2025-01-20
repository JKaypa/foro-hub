package com.alura.foro_hub.domain.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alura.foro_hub.domain.user.UserRepository;
import com.alura.foro_hub.dto.topic.TopicRequestDto;
import com.alura.foro_hub.dto.topic.TopicResponseDto;
import com.alura.foro_hub.infra.error.NotFoundException;

@Service
public class TopicService {

  @Autowired
  private TopicRepository topicRepository;

  @Autowired
  private UserRepository userRepository;

  public TopicResponseDto createTopic(TopicRequestDto topicRequest){
    var user = userRepository.findById(topicRequest.author());
    if(user.isEmpty()){
      throw new NotFoundException("Author user is not found.");
    }

    var newTopic = new Topic(topicRequest, user.get());
    var topic = topicRepository.save(newTopic);

    return new TopicResponseDto(topic);
  }


}
