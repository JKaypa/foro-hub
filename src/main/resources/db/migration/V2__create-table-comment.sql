crate table comment (
  id bigint not null auto_increment,
  message text unique not null,
  topic bigint not null,
  created_at datetime not null,
  author bigint not null,

  primary key (id),
  constraint fk_comment_topic foreign key(topic) references topic(id),
  constraint fk_comment_author foreign key(author) references user(id)
);