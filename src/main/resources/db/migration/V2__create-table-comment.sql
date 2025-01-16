crate table comment (
  id bigint auto_increment primary key,
  message text unique(message(255)) not null,
  topic_id bigint not null,
  author bigint not null,
  created_at datetime not null,

  constraint fk_comment_topic_id foreign key(topic_id) references topic(id),
  constraint fk_comment_author foreign key(author) references user(id)
);