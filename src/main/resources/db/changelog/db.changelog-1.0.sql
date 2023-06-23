--liquibase formatted sql

--changeset xotab:1
CREATE TABLE IF NOT EXISTS customer
(
    id BIGSERIAL PRIMARY KEY ,
    name VARCHAR(64) NOT NULL UNIQUE
    );