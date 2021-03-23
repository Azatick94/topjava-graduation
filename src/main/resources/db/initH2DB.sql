DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS lunches;
DROP TABLE IF EXISTS votes;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS votes_history;
DROP TABLE IF EXISTS restaurants;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

-- Restaurant Names
CREATE TABLE restaurants
(
    id   INTEGER DEFAULT GLOBAL_SEQ.nextval PRIMARY KEY,
    restaurant_name VARCHAR(100) UNIQUE NOT NULL
);

-- LUNCHES WHICH SHOULD BE UPDATED EACH DAY BY ADMIN
CREATE TABLE lunches
(
    lunch_id        INTEGER   DEFAULT GLOBAL_SEQ.nextval PRIMARY KEY,
    date_registered DATE DEFAULT now() NOT NULL,
    restaurant_id VARCHAR(100)            NOT NULL,
    lunch_name      VARCHAR                 NOT NULL,
    price           INTEGER                 NOT NULL,
    FOREIGN KEY (restaurant_id) REFERENCES restaurants(id) ON DELETE CASCADE
);

-- USER_ROLES - roles present in webapp
CREATE TABLE roles
(
    role_id INTEGER DEFAULT GLOBAL_SEQ.nextval PRIMARY KEY,
    role    VARCHAR
);

-- USERS TABLES with infos
CREATE TABLE users
(
    user_id  INTEGER      DEFAULT GLOBAL_SEQ.nextval PRIMARY KEY,
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
    restaurant_id INTEGER NOT NULL,
    vote_date       TIMESTAMP NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE,
    FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);

-- VOTES HISTORY
CREATE TABLE votes_history
(
    id INTEGER DEFAULT GLOBAL_SEQ.nextval PRIMARY KEY,
    restaurant_id INTEGER NOT NULL,
    date DATE UNIQUE NOT NULL,
    FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
)



