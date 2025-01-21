package com.alura.foro_hub.domain.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alura.foro_hub.domain.topic.TopicRepository;
import com.alura.foro_hub.domain.user.UserRepository;
import com.alura.foro_hub.dto.comment.CommentRequestDto;
import com.alura.foro_hub.dto.comment.CommentResponseDto;
import com.alura.foro_hub.dto.comment.UpdateCommentRequestDto;
import com.alura.foro_hub.infra.error.NotFoundException;

import jakarta.transaction.Transactional;

@Service
public class CommentService {

  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  private TopicRepository topicRepository;

  @Autowired
  private UserRepository userRepository;

  public CommentResponseDto createComment(CommentRequestDto commentRequest) {
    var user = userRepository.findById(commentRequest.author());
    if (user.isEmpty()) {
      throw new NotFoundException("Author user is not found.");
    }

    var topic = topicRepository.findById(commentRequest.topic());
    if(topic.isEmpty()){
      throw new NotFoundException("Topic is not found.");
    }

    var comment = commentRepository.save(new Comment(commentRequest.message(), topic.get(), user.get()));

    return new CommentResponseDto(comment);
  }

  @Transactional
  public CommentResponseDto updateComment(Long id, UpdateCommentRequestDto updateComment) {
    var comment = findCommentById(id);
    comment.update(updateComment);

    return new CommentResponseDto(comment);
  }

  public String deleteComment(Long id) {
    var comment = findCommentById(id);
    commentRepository.delete(comment);

    return "Comment deleted.";
  }

  private Comment findCommentById(Long id) {
    return commentRepository.findById(id).orElseThrow(() -> new NotFoundException("Comment not found."));
  }
}
