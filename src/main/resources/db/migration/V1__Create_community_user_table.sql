create table COMMUNITY_USER
(
    ID           INTEGER auto_increment,
    ACCOUNT_ID   CHARACTER VARYING(100),
    NAME         CHARACTER VARYING(50),
    TOKEN        CHARACTER(36),
    GMT_CREATE   BIGINT,
    GMT_MODIFIED BIGINT,
    constraint USER_PK
        primary key (ID)
);

create unique index COMMUNITY_USER_ACCOUNT_ID_UINDEX
    on COMMUNITY_USER (ACCOUNT_ID);