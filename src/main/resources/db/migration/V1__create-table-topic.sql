create table topic (
    id bigint auto_increment primary key,
    title varchar(255) not null unique,
    explanation text not null unique,
    author bigint not null,
    status enum('open', 'closed') not null,
    crated_at datetime not null,

    constraint fk_topic_author foreign key(author) references user(id)
);