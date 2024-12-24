--liquibase formatted sql

--changeset hezix:1
ALTER TABLE users
ADD COLUMN IF NOT EXISTS email varchar(64) unique;