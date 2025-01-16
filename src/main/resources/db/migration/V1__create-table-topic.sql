create table topic (
    id bigint not null auto_increment,
    title varchar(255) not null unique,
    description text unique,
    crated_at datetime not null,
    author bigint not null,

    primary key (id),
    constraint fk_topic_author foreign key(author) references user(id)
);