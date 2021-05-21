DROP TABLE IF EXISTS user_roles CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS lunches CASCADE;
DROP TABLE IF EXISTS votes CASCADE;
DROP TABLE IF EXISTS restaurants CASCADE;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

-- Restaurant Names
CREATE TABLE restaurants
(
    id              INTEGER PRIMARY KEY,
    restaurant_name VARCHAR(100) UNIQUE NOT NULL
);
CREATE UNIQUE INDEX restaurants_unique_id_restaurant_name ON restaurants (id, restaurant_name);

-- LUNCHES WHICH SHOULD BE UPDATED EACH DAY BY ADMIN
CREATE TABLE lunches
(
    id              INTEGER PRIMARY KEY,
    date_registered DATE DEFAULT now() NOT NULL,
    restaurant_id   INTEGER            NOT NULL,
    lunch_name      VARCHAR            NOT NULL,
    price           INTEGER            NOT NULL,
    FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX lunches_unique_restaurant_id_lunch_name ON lunches (restaurant_id, lunch_name);

-- USERS TABLES with infos
CREATE TABLE users
(
    id       INTEGER PRIMARY KEY,
    name     VARCHAR(100) NOT NULL,
    surname  VARCHAR(100) NOT NULL,
    email    VARCHAR(100) DEFAULT NULL,
    password VARCHAR(100) NOT NULL
);

-- USER_ROLES - roles present in webapp
CREATE TABLE user_roles
(
    id      INTEGER PRIMARY KEY,
    role    VARCHAR,
    user_id INTEGER,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

-- VOTES TABLE
CREATE TABLE votes
(
    id             INTEGER PRIMARY KEY,
    user_id        INTEGER   NOT NULL,
    restaurant_id  INTEGER   NOT NULL,
    vote_date_time TIMESTAMP NOT NULL,
    vote_date      DATE AS CAST(vote_date_time AS DATE),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX votes_unique_id_vote_date ON votes (user_id, vote_date);

