create sequence user_seq start with 1 increment by 1;
create table users (
    id bigint not null,
    archive boolean not null,
    email varchar(255),
    extra_info varchar(255),
    name varchar(255),
    password varchar(255),
    role varchar(255),
    surname varchar(255),
    primary key (id)
);
