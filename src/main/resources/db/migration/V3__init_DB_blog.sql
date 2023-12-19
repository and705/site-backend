create table categories (
id bigserial not null,
description varchar(255),
name varchar(255),
primary key (id)
);

create table comments (
    id bigserial not null,
    body varchar(255),
    email varchar(255),
    name varchar(255),
    post_id bigint not null,
    primary key (id)
);

create table posts (
    id bigserial not null,
    content varchar(255) not null,
    description varchar(255) not null,
    title varchar(255) not null,
    category_id bigint, primary key (id)
);

alter table if exists posts add constraint posts_title unique (title);
alter table if exists comments add constraint comments_posts foreign key (post_id) references posts;
alter table if exists posts add constraint posts_categories foreign key (category_id) references categories;

