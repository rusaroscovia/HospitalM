# Spring Boot E-Commerce API

This project is a Spring Boot RESTful API designed using a layered architecture. It manages three main domains:

Product
Customer
Order

The application follows best practices such as DTO mapping, validation, and secure API design.

# Tech Stack & Dependencies

The project is built using the following dependencies:

#### 🔹 Core Dependencies
- Spring Boot Starter Web :Used to build RESTful APIs and handle HTTP requests/responses.
- Spring Boot Starter Data JPA :Provides ORM support using Hibernate for database operations.
- Spring Boot Starter Validation :Enables validation using annotations like @NotNull, @Email, etc.
- Spring Boot Starter Security :Adds authentication and authorization to secure endpoints.
- Spring Boot DevTools :Improves development experience with auto-restart and live reload.
#### 🔹 Additional Libraries
Lombok
Reduces boilerplate code using annotations like @Getter, @Setter, @Builder.
MapStruct
Used for mapping between Entities and DTOs efficiently.
#### 🔹 Database
PostgreSQL Driver
Connects the application to a PostgreSQL database.
## Project Structure

The project follows a layered architecture, organized by feature modules:

src/main/java/com/example/project
│
├── product/
│   ├── controller
│   ├── service
│   ├── repository
│   ├── entity
│   ├── dto
│   └── mapper
│
├── customer/
│   ├── controller
│   ├── service
│   ├── repository
│   ├── entity
│   ├── dto
│   └── mapper
│
├── order/
│   ├── controller/
│   ├── service/
│   ├── repository/
│   ├── entity/
│   ├── dto/
│   └── mapper/
│
└── Enum/ 
|
|__ Exception/

## Layered Architecture (Monolithic Architecture)

Each module (/product, /customer, /order) follows the same structure:

1. Controller Layer:
Handles HTTP requests.
Exposes REST endpoints.

2. Service Layer:
Contains business logic.
Communicates between controller and repository.

3. Repository Layer:
Interfaces extending JpaRepository.
Handles database operations.

5. Entity Layer:
Represents database tables using JPA annotations.

6. DTO (Data Transfer Object):
Used to transfer data between layers.
Prevents exposing entity directly.

7. Mapper Layer:
Uses MapStruct to convert:
Entity ↔ DTO


## Prerequisites
 - Java 17+
 - Maven
 - PostgreSQL

* Run the Application
     - mvn spring-boot:run

* Or using packaged jar:

     - mvn clean install
     - java -jar target/app.jar

## Key Features
 - Modular structure by domain (product, customer, order)
 - Clean separation of concerns
 - DTO-based architecture with MapStruct
 - Input validation
 - PostgreSQL integration
 - API documentation with Swagger/OpenAPI
 - Global exception handling

## Future Improvements
 - Add JWT Authentication
 - Implement pagination & sorting
 - Secure endpoints with Spring Security
 - Unit & integration testing
