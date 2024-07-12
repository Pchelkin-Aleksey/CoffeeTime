--liquibase formatted sql
--changeset initbase:1

DROP TABLE IF EXISTS product, roles, users, clients, bonus_card;

create table if not exists product
(
    id BIGSERIAL PRIMARY KEY,
    title varchar(32) NOT NULL UNIQUE,
    description varchar(255)
    );

create table if not exists roles
(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    named varchar(255) NOT NULL
    );

create table if not exists users
(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    roles_id bigint REFERENCES roles (id) ON DELETE CASCADE,
    username     varchar(255) NOT NULL,
    password     varchar(255) NOT NULL,
    first_name   varchar(255) NOT NULL,
    last_name    varchar(255) NOT NULL,
    email        varchar(255) NOT NULL,
    phone_number varchar(255) NOT NULL,
    UNIQUE (username)
    );

create table if not exists clients
(
    id BIGSERIAL PRIMARY KEY,
    chat_id INTEGER,
    name varchar(255) NOT NULL,
    birthday DATE,
    email varchar(255) NOT NULL,
    registration_state varchar(255) NOT NULL,
    UNIQUE (chat_id)
    );

create table if not exists bonus_card
(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    client_id bigint REFERENCES clients (id) ON DELETE CASCADE,
    amount   varchar(255) NOT NULL,
    discount_percent    varchar(255) NOT NULL
    );

