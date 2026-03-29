# Hospital Management API

A Spring Boot RESTful API for managing hospital operations including patients, doctors, and appointments. Secured with Spring Security, JWT authentication, and OAuth2 (Google) login.

## Tech Stack

- Java 21
- Spring Boot 4.x
- Spring Security + JWT (JJWT)
- OAuth2 / Google Login
- Spring Data JPA + Hibernate
- PostgreSQL
- MapStruct
- Lombok
- Springdoc OpenAPI (Swagger UI)

## Project Structure

```
src/main/java/com/springboot/example/springbootappllication/
├── Auth/               # Security: User, JWT, filters, OAuth2
├── Patient/            # Patient CRUD
├── Doctor/             # Doctor CRUD
├── Appointment/        # Appointment booking (Patient + Doctor)
├── Enum/               # Specialization enum
├── Exceptions/         # Global exception handling
├── Response/           # Shared response DTOs
└── Config/             # Security + OpenAPI config
```

## Domains

| Domain      | Description                                      |
|-------------|--------------------------------------------------|
| Patient     | Manage patient records (name, email, diagnosis)  |
| Doctor      | Manage doctors with specialization and fees      |
| Appointment | Book appointments linking patients to doctors    |

## Security

- JWT stateless authentication
- Role-based access control (`ROLE_USER`, `ROLE_ADMIN`)
- OAuth2 login via Google
- `DELETE` endpoints restricted to `ROLE_ADMIN`

## Default Users (seeded on startup)

| Username | Password  | Role       |
|----------|-----------|------------|
| admin    | admin123  | ROLE_ADMIN |
| user     | user123   | ROLE_USER  |

## API Endpoints

### Auth
| Method | Endpoint          | Description              | Auth Required |
|--------|-------------------|--------------------------|---------------|
| POST   | /api/auth/login   | Login and receive JWT    | No            |
| GET    | /api/auth/me      | Get current user profile | Yes           |

### Patients
| Method | Endpoint          | Description         | Role Required |
|--------|-------------------|---------------------|---------------|
| POST   | /patients         | Add patient         | Any           |
| GET    | /patients         | Get all patients    | Any           |
| GET    | /patients/{id}    | Get patient by ID   | Any           |
| GET    | /patients/name    | Get patient by name | Any           |
| PUT    | /patients         | Update patient      | Any           |
| DELETE | /patients/{id}    | Delete patient      | ADMIN         |

### Doctors
| Method | Endpoint          | Description        | Role Required |
|--------|-------------------|--------------------|---------------|
| POST   | /doctors          | Add doctor         | Any           |
| GET    | /doctors          | Get all doctors    | Any           |
| GET    | /doctors/{id}     | Get doctor by ID   | Any           |
| GET    | /doctors/name     | Get doctor by name | Any           |
| PUT    | /doctors          | Update doctor      | Any           |
| DELETE | /doctors/{id}     | Delete doctor      | ADMIN         |

### Appointments
| Method | Endpoint              | Description             | Role Required |
|--------|-----------------------|-------------------------|---------------|
| POST   | /appointments         | Book appointment        | Any           |
| GET    | /appointments         | Get all appointments    | Any           |
| GET    | /appointments/{id}    | Get appointment by ID   | Any           |

## Running the App

1. Create a PostgreSQL database: `CREATE DATABASE hospital_db;`
2. Copy `application.properties.example` to `application.properties` and fill in your values
3. Run:
```bash
mvn spring-boot:run
```

## Swagger UI

```
http://localhost:8082/swagger-ui/index.html
```

## Testing with Postman

**1. Login:**
```
POST http://localhost:8082/api/auth/login
Body: { "username": "admin", "password": "admin123" }
```

**2. Use token:**
```
GET http://localhost:8082/patients
Authorization: Bearer <token>
```

**3. Google OAuth2 (browser):**
```
http://localhost:8082/oauth2/authorization/google
```

## Setup Notes

- Copy `src/main/resources/application.properties.example` to `application.properties`
- Never commit your real `application.properties` — it is in `.gitignore`
- For Google OAuth2, register your app at [Google Cloud Console](https://console.cloud.google.com) and set redirect URI to `http://localhost:8082/login/oauth2/code/google`
