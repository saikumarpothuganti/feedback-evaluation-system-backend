# Backend Repository

Spring Boot backend for Student Feedback Management System.

## Requirements

- Java 21+
- Maven 3.9+
- MySQL 8+

## Run locally

1. Start MySQL and configure env/properties.
2. Run:

```
mvn spring-boot:run
```

## Docker

Build and run backend container from this folder:

```
docker build -t feedback-backend .
docker run -p 8080:8080 feedback-backend
```
