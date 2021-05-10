# topjava-graduation

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/4e46105892fe4b779679a35b1e631376)](https://app.codacy.com/gh/Azatick94/topjava-graduation?utm_source=github.com&utm_medium=referral&utm_content=Azatick94/topjava-graduation&utm_campaign=Badge_Grade_Settings)

topjava-graduation project

---

# Project requirements

Design and implement a REST API using Hibernate/Spring/SpringMVC (or Spring-Boot) without frontend.

The task is:

Build a voting system for deciding where to have lunch.

- [ ] 2 types of users: admin and regular user
- [ ] Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
- [ ] Menu changes each day (admins do the updates)
- [ ] Users can vote on which restaurant they want to have lunch at
- [ ] Only one vote counted per user
- [ ] If user votes again the same day:
    - [ ] If it is before 11:00 we assume that he changed his mind.
    - [ ] If it is after 11:00 then it is too late, vote can't be changed Each restaurant provides a new menu each day.

As a result, provide a link to github repository. It should contain the code, README.md with API documentation and
couple curl commands to test it.

---
P.S.: Make sure everything works with latest version that is on github :)

P.P.S.: Assume that your API will be used by a frontend developer to build frontend on top of that.

---

#    * RESULTS

---

##    * SWAGGER documentation

* Json Format documentation
  http://localhost:8080/api-docs/
* Swagger UI documentation
  http://localhost:8080/swagger-ui.html

---

##    * SECURITY CONFIGS

### ADMIN: <br>

admin@mail.ru : admin

### USER: <br>

user@mail.ru : user

---

##    * DATABASE MODEL STRUCTURE

![alt text](src/main/resources/static/images/voting_app_diagram.png)

[comment]: <> (# TODO)
[comment]: <> (- [Link to Postman Project File]&#40;config/topjava-graduation.postman_collection.json&#41;)

---

##    * LIST of CURL Commands:

### RESTAURANT_CONTROLLER

<i>- Get All Restaurants (user+admin):</i>

    curl -L -X GET 'http://localhost:8080/rest/restaurant' -H 'Authorization: Basic dXNlckBtYWlsLnJ1OnVzZXI='

<i>- Get Restaurant With ID = 100009 (user+admin):</i>

    curl -L -X GET 'http://localhost:8080/rest/restaurant/100009' -H 'Authorization: Basic dXNlckBtYWlsLnJ1OnVzZXI='

<i>- Save New Restaurant with Name="New_Restaurant" (admin):</i>

    curl -L -X POST 'http://localhost:8080/rest/restaurant' -H 'Authorization: Basic YWRtaW5AbWFpbC5ydTphZG1pbg==' -H '
    Content-Type: application/json' --data-raw '{
    "restaurantName": "New_Restaurant"
    }'

<i>- Update Restaurant With ID = 100009: (admin)</i>

    curl -L -X PUT 'http://localhost:8080/rest/restaurant/100009' -H 'Authorization: Basic YWRtaW5AbWFpbC5ydTphZG1pbg==' -H 'Content-Type: application/json' --data-raw '{
    "restaurantName": "Russian Pub New Name"
    }'

<i>- Delete Restaurant With ID = 100010: (admin)</i>

    curl -L -X DELETE 'http://localhost:8080/rest/restaurant/100010' -H 'Authorization: Basic YWRtaW5AbWFpbC5ydTphZG1pbg=='

### USER_CONTROLLER

<i>- Get All Users (admin):</i>

    curl -L -X GET 'http://localhost:8080/rest/users' -H 'Authorization: Basic YWRtaW5AbWFpbC5ydTphZG1pbg=='

<i>- Find User By Name="Azat" (admin):</i>

    curl -L -X GET 'http://localhost:8080/rest/users/by/name?name=Azat' -H 'Authorization: Basic YWRtaW5AbWFpbC5ydTphZG1pbg=='

<i>- Get User By Id=100000 (admin):</i>

    curl -L -X GET 'http://localhost:8080/rest/users/by/id?id=100000' -H 'Authorization: Basic YWRtaW5AbWFpbC5ydTphZG1pbg=='

### LUNCH_CONTROLLER

<i>- Get All Lunches (admin+user):</i>

    curl -L -X GET 'http://localhost:8080/rest/lunch' -H 'Authorization: Basic dXNlckBtYWlsLnJ1OnVzZXI='

<i>- Get Lunch By Id = 100014 (admin+user):</i>

    curl -L -X GET 'http://localhost:8080/rest/lunch/100014' -H 'Authorization: Basic dXNlckBtYWlsLnJ1OnVzZXI='

<i>- Get List of Lunches By RestaurantName = "AnderSon" (admin+user):</i>

    curl -L -X GET 'http://localhost:8080/rest/lunch/by_restaurant/AnderSon' -H 'Authorization: Basic dXNlckBtYWlsLnJ1OnVzZXI=' 

<i>- Get List of Lunches Between Dates =  (admin+user):</i>

    curl -L -X GET 'http://localhost:8080/rest/lunch/filter?startDate=2021-01-02&endDate=2021-01-02' -H 'Authorization: Basic dXNlckBtYWlsLnJ1OnVzZXI='

<i>- Save New Lunch With Name =  (admin):</i>



<i>- Update Existing Lunch With Id =  (admin):</i>



<i>- Delete Lunch With Id =   (admin):</i>

    curl -L -X DELETE 'http://localhost:8080/rest/lunch/100015' -H 'Authorization: Basic YWRtaW5AbWFpbC5ydTphZG1pbg=='


### VOTE_CONTROLLER

<i>- Get All Votes (user+admin):</i>

    curl -L -X GET 'http://localhost:8080/rest/vote' -H 'Authorization: Basic dXNlckBtYWlsLnJ1OnVzZXI='

<i>- Get Vote By Id = 100034 (user+admin):</i>

    curl -L -X GET 'http://localhost:8080/rest/vote/100034' -H 'Authorization: Basic dXNlckBtYWlsLnJ1OnVzZXI='

<i>- Save New Vote =  (admin+user):</i>



<i>- Update Existing Vote With Id =  (admin+user):</i>



<i>- Delete Vote With Id =   (admin+user):</i>

    curl -L -X DELETE 'http://localhost:8080/rest/vote/100035' -H 'Authorization: Basic YWRtaW5AbWFpbC5ydTphZG1pbg=='


### VOTE_HISTORY_CONTROLLER

<i>- Get Restaurant Voting Results (admin+user):</i>

    curl -L -X GET 'http://localhost:8080/rest/vote_history' -H 'Authorization: Basic dXNlckBtYWlsLnJ1OnVzZXI='

