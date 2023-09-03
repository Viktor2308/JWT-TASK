--liquibase formatted sql
-- changeset derkachev:1000000-1
-- comment: Initial creation of table users
CREATE TABLE users
(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL
);