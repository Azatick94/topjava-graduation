DELETE
FROM lunches;
DELETE
FROM user_roles;
DELETE
FROM users;
DELETE
FROM votes;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO user_roles (role)
VALUES ('USER'),
       ('ADMIN');

INSERT INTO users (name, surname, email, password)
VALUES ('Azat', 'Burkhanov', 'azburhanov@mail.ru', 'password'),
       ('Vadim', 'Demchenko', 'demo@gmail.com', 'qwerty'),
       ('Petr', 'Petrov', 'petrov_petr@mail.ru', 'qwerty123'),
       ('Elena', 'Barinova', 'lena_barinova@gmail.com', '123qwerty');

-- list of restaurants
-- 'AnderSon', 'Russian Pub', 'Italoniya', 'Piccochino', 'Bardak', 'Khachapuri'
INSERT INTO lunches (date_registered, restaurant_name, lunch_name, price)
VALUES ('2021-01-01 10:00:00', 'AnderSon', 'Стейк лосося с ризотто из булгура и томатами', 710),
       ('2021-01-01 10:00:00', 'AnderSon', 'Том Ям с креветками на кокосовом молоке', 410),
       ('2021-01-01 10:00:00', 'AnderSon', 'Брускетта со слабосоленым лососем и сливочным сыром', 520),
       ('2021-01-01 10:00:00', 'AnderSon',
        'Горячий сэндвич с индейкой, сыром моцарелла, вялеными томатами и домашней заправкой цезарь на листьях салата романо',
        360),
       ('2021-01-01 10:00:00', 'AnderSon',
        'Фирменные сырники от АндерСон из свежего творога с протертой малиной и сметаной', 370),
       ('2021-01-01 10:00:00', 'Russian Pub', 'Пай по-строгановски', 730),
       ('2021-01-01 10:00:00', 'Russian Pub', 'Куриные крылья', 480),
       ('2021-01-01 10:00:00', 'Russian Pub', 'Бургер со щукой', 450),
       ('2021-01-01 10:00:00', 'Russian Pub', 'Бургер с пастрами и белыми груздями', 590),
       ('2021-01-01 10:00:00', 'Italoniya', 'Тартирно с хурмой', 420),
       ('2021-01-01 10:00:00', 'Italoniya', 'Шоколадный торт', 350),
       ('2021-01-01 10:00:00', 'Italoniya', 'Фарфале с лососем и икрой', 640),
       ('2021-01-01 10:00:00', 'Piccochino', 'ФИРМЕННАЯ ПИЦЦА С КОЛБАСКАМИ В БОРТИКЕ', 650),
       ('2021-01-01 10:00:00', 'Piccochino', 'ПИЦЦА ПАРМА РУККОЛА', 670),
       ('2021-01-01 10:00:00', 'Bardak', 'Гриль сет Izgara 1000 гр', 1600),
       ('2021-01-01 10:00:00', 'Bardak', 'Дана тантуни Dana tantuni 210 гр', 480),
       ('2021-01-01 10:00:00', 'Bardak', 'Креветки Кадаиф Kadayifli karides 150 гр', 480),
       ('2021-01-01 10:00:00', 'Khachapuri', 'Хачапури на шампуре', 260),
       ('2021-01-01 10:00:00', 'Khachapuri', 'Суп харчо из говядины', 380),
       ('2021-01-01 10:00:00', 'Khachapuri', 'Баранья корейка с красной аджикой', 1290);

INSERT INTO votes (user_id, vote_date, restaurant_name)
VALUES (100002, '2021-01-02 10:00:00', 'Bardak'),
       (100003, '2021-01-02 15:00:00', 'Piccochino'),
       (100004, '2021-01-02 11:00:00', 'Khachapuri'),
       (100005, '2021-01-02 09:00:00', 'Piccochino');

