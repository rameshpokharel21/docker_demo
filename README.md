# 🚀 Spring Boot Project with Docker
A simple Spring Boot application deployment with Docker.

## ✨ Features
- Employee management with validation
- DTO -> Entity mapping using ModelMapper
- PostgreSQL integration
- Global Exception Handling
- Deployment using Docker and Docker compose
- Swagger UI and OpenAPI

## ⚙️ Requirements
- Docker Desktop or (Docker Engine + Docker Compose v2)
- API Client such as Postman or Bruno(optional if using Swagger ui)
- Environment Variables file (.env) created as suggested below

## 🔏Environment Variables
- create .env file with following in the project's root folder:

```declarative
    POSTGRES_USER=user
    POSTGRES_PASSWORD=your_postgres_password
    POSTGRES_DB=employee_db

    SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/employee_db
    SPRING_DATASOURCE_USERNAME=user
    SPRING_DATASOURCE_PASSWORD=your_postgres_password

```
- there are two sets inside environment variables 
- first is for postgres database
- second is for Spring Data JPA
- database username is `user` in docker-compose database healthcheck
- username, password, and database name should match in all places
- service name for database is postgres in docker-compose, so postgres is used in url instead of localhost

## ▶️ Getting Started
- Install Docker Desktop, API Client
- Clone the repo
- Make sure Docker Engine is running
- Go to the root of the project(`cd docker_demo`)
- To create and run images and containers: `docker compose up --build -d`
- Check if there are two containers running : `docker ps`
- Check if there are two images: `docker images`
- To stop and remove containers: `docker compose down`
- To create and run again (with same images): `docker compose up -d`

## 📡 API Endpoints
- Use interactive Swagger UI with following url in the browser:
    http://localhost:9090/swagger-ui.html
- List API documentation in json using OpenAPI with following url: 
    http://localhost:9090/v3/api-docs
- If using postman or bruno, followings are the api endpoints:
- 
      base url: http://localhost:9090
    
- add an employee: `/api/employees` Method: POST, body example:
    ```
   {
        "firstName": "james",
        "lastName": "mann",
        "email": "james@example.com"
    }
  ```
- get all employees: `/api/employees` Method: GET
    
- get an employee: `/api/employees/{id}` Method: GET
    
- update an employee: `/api/employees/{id}` Method: PUT, body sample:
 ```
   {
        "firstName": "james",
        "lastName": "mann",
        "email": "james_mann@myemail.com"
    }
  ```
    
- delete an employee: `/api/employees/{id}` Method: DELETE

## 📈 Explore Database
- `docker ps` should show the database container(postgres_db) running
- Note that database localhost(127.0.0.1) port is set 5433 in docker-compose file
- `docker exec -it postgres_db psql -U user -d employees_db`takes to psql command
- or in two steps: 1. `docker exec -it postgres_db bash`
  2.`psql -U user -d employee_db`
- List tables : `\dt`
- List database: `\l`
- `select * from employees`
- Use other psql commands.
- Save database directly using database password from command line: `pg_dump -U user -h 127.0.0.1 -p 5433 employee_db > backup.sql`