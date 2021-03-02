DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS lunches;
DROP TABLE IF EXISTS votes;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

-- LUNCHES WHICH SHOULD BE UPDATED EACH DAY BY ADMIN
CREATE TABLE lunches
(
    lunch_id        INTEGER DEFAULT GLOBAL_SEQ.nextval PRIMARY KEY,
    date_registered TIMESTAMP DEFAULT now() NOT NULL,
    restaurant_name VARCHAR(100)            NOT NULL,
    lunch_name      VARCHAR                 NOT NULL,
    price           INTEGER                 NOT NULL
);

-- USER_ROLES - roles present in webapp
CREATE TABLE user_roles
(
    role_id INTEGER DEFAULT GLOBAL_SEQ.nextval PRIMARY KEY,
    role    VARCHAR
);

-- USERS TABLES with infos
CREATE TABLE users
(
    user_id  INTEGER DEFAULT GLOBAL_SEQ.nextval PRIMARY KEY,
    name     VARCHAR(100) NOT NULL,
    surname  VARCHAR(100) NOT NULL,
    email    VARCHAR(100) DEFAULT NULL,
    password VARCHAR(100) NOT NULL
);

-- VOTES TABLE
CREATE TABLE votes
(
    vote_id         INTEGER DEFAULT GLOBAL_SEQ.nextval PRIMARY KEY,
    user_id         INTEGER   NOT NULL,
    vote_date       TIMESTAMP NOT NULL,
    restaurant_name VARCHAR(100),
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE
);



