CREATE DATABASE cw07;

CREATE TABLE users_tb(
    user_id serial primary key,
    nat_code varchar(60) not null,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    username varchar(25) not null,
    password varchar(25) not null,
    email varchar(25) not null
);