--liquibase formatted sql
-- changeset derkachev:1000000-1
-- comment: Initial creation of table users
CREATE TABLE users
(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL
);
-- changeset derkachev:1000000-2
INSERT INTO users(id, name, password)
VALUES
                                          ('1',
                                           'user@test.ru',
                                           '$2a$12$nGwpF/6/pVCIdPHJudSNcOvu8DAlCiGxRJINZsJxHPXzRfUSRr3IC');
-- changeset derkachev:1000000-3
ALTER TABLE users RENAME COLUMN name to username;

-- changeset derkachev:1000000-4
CREATE TABLE message
(
    id BIGSERIAL PRIMARY KEY,
    text VARCHAR NOT NULL,
    user_id BIGINT
)