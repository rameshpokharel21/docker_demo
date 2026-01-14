# 🚀 Spring Boot Project with Docker
A simple Spring Boot application with layered architechture with PostgreSQL.

## ✨ Features
- Employee management with validation
- DTO -> Entity mapping using ModelMapper
- PostgreSQL integration
- Global Exception Handling(coming...)
- Deployment using docker and docker-compose

## ⚙️ Requirements
- Java : Version 25
- Maven or Maven Wrapper
- PostgreSQL : 16+
- create database named "docker_db"

## 🔏Environment Variables
```declarative
    SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/docker_db
    SPRING_DATASOURCE_USERNAME=postgres
    SPRING_DATASOURCE_PASSWORD=your_postgres_password

```

## 📡 API Endpoints
base url: http://localhost:8080

add an employee: `/api/employees` Method: POST

get all employees: `/api/employees` Method: GET

get an employee: `/api/employees/{employee_id}` Method: GET

## 🔌run.sh
To run the application with required environment variables from .env file, 
simply run this bash file from command line in intelliJ.
```bash
  #exit on error
  set -e
  
  #add env variable
  set -a
  source .env
  set +a
  
  #run spring boot using maven wrapper
  ./mvnw spring-boot:run
```

