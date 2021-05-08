# topjava-graduation

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/4e46105892fe4b779679a35b1e631376)](https://app.codacy.com/gh/Azatick94/topjava-graduation?utm_source=github.com&utm_medium=referral&utm_content=Azatick94/topjava-graduation&utm_campaign=Badge_Grade_Settings)

topjava-graduation project

---
# Project requirements

Design and implement a REST API using Hibernate/Spring/SpringMVC (or Spring-Boot) without frontend.

The task is:

Build a voting system for deciding where to have lunch.

- [x] 2 types of users: admin and regular user
- [x] Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
- [x] Menu changes each day (admins do the updates)
- [x] Users can vote on which restaurant they want to have lunch at
- [ ] Only one vote counted per user
- [ ] If user votes again the same day:
    - [ ] If it is before 11:00 we assume that he changed his mind.
    - [ ] If it is after 11:00 then it is too late, vote can't be changed
      Each restaurant provides a new menu each day.

As a result, provide a link to github repository. It should contain the code, README.md with API documentation and couple curl commands to test it.

---
P.S.: Make sure everything works with latest version that is on github :)

P.P.S.: Assume that your API will be used by a frontend developer to build frontend on top of that.


---
# Results

- [Link to Postman Project File](config/topjava-graduation.postman_collection.json)

---
## List of curl commands:

---
## SWAGGER documentation
* Json Format documentation
http://localhost:8080/api-docs/
* Swagger UI documentation
http://localhost:8080/swagger-ui.html


