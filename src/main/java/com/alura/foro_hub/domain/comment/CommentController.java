package com.alura.foro_hub.domain.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.foro_hub.dto.comment.CommentRequestDto;
import com.alura.foro_hub.dto.comment.CommentResponseDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("comment")
public class CommentController {

  @Autowired
  CommentService commentService;

  @PostMapping
  public ResponseEntity<CommentResponseDto> createComment(@RequestBody @Valid CommentRequestDto commentRequest){
    var comment = commentService.createComment(commentRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(comment);
  }
}
