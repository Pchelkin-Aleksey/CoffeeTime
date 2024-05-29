--liquibase formatted sql

--changeset initbase:1
create table if not exists product
(
    id BIGSERIAL PRIMARY KEY,
    title varchar(32) NOT NULL UNIQUE,
    description varchar(255)
);
