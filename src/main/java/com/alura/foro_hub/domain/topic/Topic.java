package com.alura.foro_hub.domain.topic;

import java.time.LocalDateTime;
import java.util.List;

import com.alura.foro_hub.domain.comment.Comment;
import com.alura.foro_hub.domain.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Topic {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  private String description;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "topic")
  private List<Comment> comments;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "author")
  private User author;

  private Status status;

  private LocalDateTime createdAt;
}
