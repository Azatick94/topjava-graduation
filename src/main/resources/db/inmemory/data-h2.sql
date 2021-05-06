DELETE
FROM LUNCHES;
DELETE
FROM RESTAURANTS;
DELETE
FROM ROLES;
DELETE
FROM USERS;
DELETE
FROM VOTES;
DELETE
FROM VOTES_HISTORY;

INSERT INTO ROLES (ID, ROLE)
VALUES (NEXT VALUE FOR global_seq, 'USER'),
       (NEXT VALUE FOR global_seq, 'ADMIN');

INSERT INTO USERS (ID, NAME, SURNAME, EMAIL, PASSWORD)
VALUES (NEXT VALUE FOR global_seq, 'Azat', 'Burkhanov', 'azburhanov@mail.ru', 'password'),
       (NEXT VALUE FOR global_seq, 'Vadim', 'Demchenko', 'demo@gmail.com', 'qwerty'),
       (NEXT VALUE FOR global_seq, 'Petr', 'Petrov', 'petrov_petr@mail.ru', 'qwerty123'),
       (NEXT VALUE FOR global_seq, 'Elena', 'Barinova', 'lena_barinova@gmail.com', '123qwerty');

-- list of restaurants
INSERT INTO RESTAURANTS (ID, RESTAURANT_NAME)
VALUES (NEXT VALUE FOR global_seq, 'AnderSon'),
       (NEXT VALUE FOR global_seq, 'Russian Pub'),
       (NEXT VALUE FOR global_seq, 'Italoniya'),
       (NEXT VALUE FOR global_seq, 'Piccochino'),
       (NEXT VALUE FOR global_seq, 'Bardak'),
       (NEXT VALUE FOR global_seq, 'Khachapuri');

-- lunches
INSERT INTO LUNCHES (ID, DATE_REGISTERED, RESTAURANT_ID, LUNCH_NAME, PRICE)
VALUES (NEXT VALUE FOR global_seq, '2021-01-01', 100006, 'Стейк лосося с ризотто из булгура и томатами', 710),
       (NEXT VALUE FOR global_seq, '2021-01-01', 100006, 'Том Ям с креветками на кокосовом молоке', 410),
       (NEXT VALUE FOR global_seq, '2021-01-01', 100006, 'Брускетта со слабосоленым лососем и сливочным сыром', 520),
       (NEXT VALUE FOR global_seq, '2021-01-01', 100006,
        'Горячий сэндвич с индейкой, сыром моцарелла, вялеными томатами и домашней заправкой цезарь на листьях салата романо',
        360),
       (NEXT VALUE FOR global_seq, '2021-01-01', 100006,
        'Фирменные сырники от АндерСон из свежего творога с протертой малиной и сметаной', 370),
       (NEXT VALUE FOR global_seq, '2021-01-01', 100007, 'Пай по-строгановски', 730),
       (NEXT VALUE FOR global_seq, '2021-01-01', 100007, 'Куриные крылья', 480),
       (NEXT VALUE FOR global_seq, '2021-01-01', 100007, 'Бургер со щукой', 450),
       (NEXT VALUE FOR global_seq, '2021-01-01', 100007, 'Бургер с пастрами и белыми груздями', 590),
       (NEXT VALUE FOR global_seq, '2021-01-01', 100008, 'Тартирно с хурмой', 420),
       (NEXT VALUE FOR global_seq, '2021-01-01', 100008, 'Шоколадный торт', 350),
       (NEXT VALUE FOR global_seq, '2021-01-01', 100008, 'Фарфале с лососем и икрой', 640),
       (NEXT VALUE FOR global_seq, '2021-01-01', 100009, 'ФИРМЕННАЯ ПИЦЦА С КОЛБАСКАМИ В БОРТИКЕ', 650),
       (NEXT VALUE FOR global_seq, '2021-01-01', 100009, 'ПИЦЦА ПАРМА РУККОЛА', 670),
       (NEXT VALUE FOR global_seq, '2021-01-01', 100009, 'Гриль сет Izgara 1000 гр', 1600),
       (NEXT VALUE FOR global_seq, '2021-01-01', 100010, 'Дана тантуни Dana tantuni 210 гр', 480),
       (NEXT VALUE FOR global_seq, '2021-01-02', 100010, 'Креветки Кадаиф Kadayifli karides 150 гр', 480),
       (NEXT VALUE FOR global_seq, '2021-01-01', 100011, 'Хачапури на шампуре', 260),
       (NEXT VALUE FOR global_seq, '2021-01-01', 100011, 'Суп харчо из говядины', 380),
       (NEXT VALUE FOR global_seq, '2021-01-02', 100011, 'Баранья корейка с красной аджикой', 1290);

-- this is example votes
INSERT INTO VOTES (ID, USER_ID, VOTE_DATE_TIME, RESTAURANT_ID)
VALUES (NEXT VALUE FOR global_seq, 100002, '2021-01-01 10:00:00', 100010),
       (NEXT VALUE FOR global_seq, 100003, '2021-01-01 09:00:00', 100009),
       (NEXT VALUE FOR global_seq, 100004, '2021-01-02 09:00:00', 100009);

