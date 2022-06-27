# <span style="vertical-align: sub"><img src="src/main/resources/cinema.png"></span> Cinema Application <span style="vertical-align: sub"><img src="src/main/resources/cinema.png"></span>

### <span style="vertical-align: middle"><img src="src/main/resources/java.png"></span> Project description:

This is a basic implementation of a cinema online shop, created using Spring and Hibernate frameworks, database usage, REST principles and supports registration, authentication and other CRUD operations.
All data is displayed to user in JSON format.

### <span style="vertical-align: middle"><img src="src/main/resources/features.png"></span> Features:

This application uses database to store information about users, shopping carts, orders, tickets, cinema halls and movie sessions.
In addition, it has basic features for authentication and authorization of users with `admin` and `user` roles.
Each user has his own shopping cart and history of orders.
Each ticket contains details on a movie session and user.
Each movie session contains details on a movie, cinema hall and showtime.

- registration of a user and giving user's default role
- authentication of a user
- get list of cinema halls/movies/available movie sessions by `all users`
- create cinema hall/movie/movie session by `admin`
- update/remove movie session by `admin`
- create/get user's history of orders by `user`
- get user's shopping cart by current `user`
- update user's shopping cart adding tickets for movie sessions by current `user`
- get user by email for `admin`

### <span style="vertical-align: middle"><img src="src/main/resources/structure.png"></span> Structure:

1. `main.java` package folders:

    - `config` - contains configuration classes
    - `controller` - contains presentation layer classes
    - `dao` - contains DAO layer interfaces and classes
    - `dto` - contains request and response DTOs for models
    - `exception` - contains custom exceptions
    - `lib` - contains custom annotations for data validation
    - `model` - contains models for cinema hall, movie, movies session, order, role, shopping cart, ticket and user
    - `service` - contains business logic layer interfaces/classes and mappers for DTOs
    - `util` - contains utility classes

2. `resources` package:
    - properties for connecting to database and creating/managing required schema and tables
    - icons for `README.md`

### <span style="vertical-align: middle"><img src="src/main/resources/endpoints.png"></span> List of endpoints:

- `POST`: /register - all
- `GET`: /cinema-halls - user/admin
- `POST`: /cinema-halls - admin
- `GET`: /movies - user/admin
- `POST`: /movies - admin
- `GET`: /movie-sessions/available - user/admin
- `GET`: /movie-sessions/{id} - user/admin
- `POST`: /movie-sessions - admin
- `PUT`: /movie-sessions/{id} - admin
- `DELETE`: /movie-sessions/{id} - admin
- `GET`: /orders - user
- `POST`: /orders/complete - user
- `PUT`: /shopping-carts/movie-sessions - user
- `GET`: /shopping-carts/by-user - user
- `GET`: /users/by-email - admin

First off, to check the work of application you had to add user login details for currently logged-in user in authorization tab.
For this purpose, please use `Basic Auth` type and add login and password information.

POST request example using Postman:
```
http://localhost:8080/cinema-halls - URL
{"capacity":"number of places", "description":"your description"} - body;
```

### <span style="vertical-align: middle"><img src="src/main/resources/technologies.png"></span> Technologies:

- `Spring`
- `Hibernate`
- `Maven`
- `JPA`
- `REST`
- `MySQL`
- `Tomcat`

### <span style="vertical-align: middle"><img src="src/main/resources/run.png"></span> Instructions to run the project

- Install IDE to your PC
- Clone the project to your IDE (e.g. IntelliJ IDEA)
- Install MySQL to your PC and create new MySQL connection
- Create new schema using name `cinema_db`
- Change parameters in `db.properties`: `db.user`, `db.password` for yours (they should match `username` and `password` from your MySQL connection)
- Download Tomcat and add configuration in your IDE (for this project `v9.0.50` was used)
- Run project with Tomcat
- Use `Postman` and add login details in authorization tab: `admin@i.ua|admin123` for admin or `user@i.ua|user1234` for user
- Send GET/POST/PUT/DELETE requests using `Postman`
