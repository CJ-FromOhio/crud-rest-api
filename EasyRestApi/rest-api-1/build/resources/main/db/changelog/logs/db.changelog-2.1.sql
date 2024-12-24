--liquibase formatted sql

--changeset hezix:1
ALTER TABLE users
ADD COLUMN IF NOT EXISTS created_at TIMESTAMP;

ALTER TABLE users
    ADD COLUMN IF NOT EXISTS updated_at TIMESTAMP;

ALTER TABLE users
    ADD COLUMN IF NOT EXISTS created_by varchar(64);

ALTER TABLE users
    ADD COLUMN IF NOT EXISTS updated_by varchar(64);