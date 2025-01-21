package com.alura.foro_hub.domain.topic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.alura.foro_hub.domain.user.UserRepository;
import com.alura.foro_hub.dto.topic.TopicDetailsResponseDto;
import com.alura.foro_hub.dto.topic.TopicRequestDto;
import com.alura.foro_hub.dto.topic.TopicResponseDto;
import com.alura.foro_hub.dto.topic.UpdateTopicRequestDto;
import com.alura.foro_hub.infra.error.NotFoundException;

import jakarta.transaction.Transactional;

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

  public Page<TopicResponseDto> getAllTopics(Pageable pageable){
    return topicRepository.findAll(pageable).map(TopicResponseDto::new);
  }

  public TopicDetailsResponseDto getTopic(Long id) {
    var topic = getTopicById(id);
    
    return new TopicDetailsResponseDto(topic);
  }

  @Transactional
  public TopicResponseDto updateTopic(UpdateTopicRequestDto updateTopic, long id) {
    var topic = getTopicById(id);

    return new TopicResponseDto(topic.update(updateTopic));
  }

  public String deleteTopic(Long id) {
    var topic = getTopicById(id);

    topicRepository.delete(topic);

    return "Topic deleted successfully.";
  }

  private Topic getTopicById(Long id){
    var topic = topicRepository.findById(id);
    if(topic.isEmpty()){
      throw new NotFoundException("Topic not found.");
    }

    return topic.get();
  }


}
