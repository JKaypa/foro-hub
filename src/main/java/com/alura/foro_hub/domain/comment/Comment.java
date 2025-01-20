package com.alura.foro_hub.domain.comment;

import java.time.LocalDateTime;

import com.alura.foro_hub.domain.topic.Topic;
import com.alura.foro_hub.domain.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String message;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "topic_id")
  private Topic topic;

  private LocalDateTime createdAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "author")
  private User author;

  public Comment(String message, Topic topic, User author){
    this.message = message;
    this.topic = topic;
    this.author = author;
    this.createdAt = LocalDateTime.now();
  }
}
