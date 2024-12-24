--liquibase formatted sql

--changeset hezix:1
CREATE TABLE IF NOT EXISTS users
(
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(64) NOT NULL UNIQUE,
    firstname VARCHAR(64),
    lastname VARCHAR(64),
    role VARCHAR(32)
)