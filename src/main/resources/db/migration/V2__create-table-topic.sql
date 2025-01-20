create table topic (
    id bigint auto_increment primary key,
    title varchar(255) not null unique,
    description text not null,
    author bigint not null,
    status enum('open', 'closed') not null,
    created_at datetime not null,

    unique(description(255)),
    
    constraint fk_topic_author foreign key(author) references user(id)
);