# Task Management App

A Spring Boot REST API application for managing tasks. This project provides CRUD operations for creating, updating, retrieving, and deleting tasks.

## Features

* Create a new task
* View all tasks
* View a task by ID
* Update task details
* Delete a task
* Input validation using `@Valid`
* Exception handling
* RESTful API design
* Database integration using Spring Data JPA

## Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* Maven
* PostgreSQL

## Project Structure

```text
src/main/java
├── controller
├── service
├── repository
├── entity
├── exception
└── TaskManagementApplication
```

## API Endpoints

### Create Task

**POST** `/api/tasks`

### Get All Tasks

**GET** `/api/tasks`

### Get Task By ID

**GET** `/api/tasks/{id}`

### Update Task

**PUT** `/api/tasks/{id}`

### Delete Task

**DELETE** `/api/tasks/{id}`

## Database Configuration

Update `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```

## Installation & Setup

### Clone the Repository

```bash
git clone https://github.com/YogitaTayde/Task-Management-App.git
```

### Navigate to Project Directory

```bash
cd Task-Management-App
```

### Build the Project

```bash
mvn clean install
```

### Run the Application

```bash
mvn spring-boot:run
```

The application will start on:

```text
http://localhost:8080
```

## Testing with Postman

* POST `/api/tasks`
* GET `/api/tasks`
* GET `/api/tasks/{id}`
* PUT `/api/tasks/{id}`
* DELETE `/api/tasks/{id}`

## Author

**Yogita Tayde**

GitHub: https://github.com/YogitaTayde
