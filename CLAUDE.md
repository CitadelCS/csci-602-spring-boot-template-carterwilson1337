# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Spring Boot 3.3.2 REST API template for CSCI 602 coursework using Java 17, PostgreSQL, and Maven. The application runs on port 5001 and provides Swagger UI at http://localhost:5001/swagger-ui/index.html.

## Essential Commands

### Build and Run
```bash
# Build the project
./mvnw clean install

# Run the application
./mvnw spring-boot:run

# Run tests
./mvnw test

# Run specific test
./mvnw test -Dtest=ClassName#methodName
```

### Windows Users
Replace `./mvnw` with `.\mvnw` for all Maven commands.

## Architecture

### Package Structure
- `edu.citadel.main` - Application entry point (RestApiApplication.java with @ComponentScan)
- `edu.citadel.api` - REST controllers/endpoints
- `edu.citadel.api.request` - Request DTOs
- `edu.citadel.dal` - Data Access Layer with JPA repositories
- `edu.citadel.dal.model` - JPA entities (scanned from ApplicationConfig)
- `edu.citadel.config` - Spring configuration classes

### Configuration
- JPA repositories enabled via `@EnableJpaRepositories(basePackages = "edu.citadel.dal")`
- Entities scanned from `@EntityScan("edu.citadel.dal.model")`
- Component scanning from `@ComponentScan(value = {"edu.citadel"})`
- Database: PostgreSQL via JDBC
- Migrations: Flyway (migrations in `src/main/resources/db/migration/`)

### Key Dependencies
- Spring Boot Data JPA & JDBC
- Hibernate Core 6.5.2
- Flyway 10.17.1 (PostgreSQL)
- Lombok 1.18.32
- SpringDoc OpenAPI 2.6.0 (Swagger)
- Jackson 2.17.2
- Twilio SDK 10.4.1

### Database Configuration
Profiles configured in `src/main/resources/application*.yaml`:
- `application.yaml` - main config (port 5001, datasource placeholders)
- `application-test.yaml` - test profile
- `application-ghci.yaml` - GitHub Codespaces profile

When setting up datasources in IntelliJ with Heroku, configure SSL settings on the Advanced tab per README instructions.

### REST Pattern
Controllers use constructor injection with `@Autowired`, return `ResponseEntity<T>`, and define routes with `@RequestMapping` at class level. Endpoints consume/produce `MediaType.APPLICATION_JSON_VALUE`.
