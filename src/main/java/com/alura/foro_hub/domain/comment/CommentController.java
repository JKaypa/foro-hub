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
import com.alura.foro_hub.dto.comment.UpdateCommentRequestDto;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("comment")
@SecurityRequirement(name = "bearer-key")
public class CommentController {

  @Autowired
  CommentService commentService;

  @PostMapping
  public ResponseEntity<CommentResponseDto> createComment(@RequestBody @Valid CommentRequestDto commentRequest) {
    var comment = commentService.createComment(commentRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(comment);
  }

  @PutMapping("/{id}")
  public ResponseEntity<CommentResponseDto> editComment(@PathVariable Long id,
      @RequestBody @Valid UpdateCommentRequestDto updateComment) {
    return ResponseEntity.ok(commentService.updateComment(id, updateComment));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteComment(@PathVariable Long id) {
    return ResponseEntity.ok(commentService.deleteComment(id));
  }
}
