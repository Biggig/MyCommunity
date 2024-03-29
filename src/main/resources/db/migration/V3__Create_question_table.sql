create table question
(
    title         varchar(50),
    id            int auto_increment,
    description   TEXT,
    gmt_create    BIGINT,
    gmt_modified  BIGINT,
    creator       int,
    comment_count int default 0,
    view_count    int default 0,
    like_count    int default 0,
    tag           varchar(256),
    constraint QUESTION_PK
        primary key (id)
);

