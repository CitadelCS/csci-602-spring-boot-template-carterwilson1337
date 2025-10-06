# Cucumber Integration Assignment - Step-by-Step Guide

## Overview
Integrate Cucumber into your Spring Boot application and write 3 tests for your REST API endpoints.

## Prerequisites
- [ ] Form a group of 2-3 members from your team
- [ ] Identify which endpoints you'll test (need 3 tests)
- [ ] Review the tutorial: https://cucumber.io/docs/guides/10-minute-tutorial/

## Step 1: Add Cucumber Dependencies

Add to `pom.xml` in the `<dependencies>` section:
```xml
<!-- Cucumber dependencies -->
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-java</artifactId>
    <version>7.14.0</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-spring</artifactId>
    <version>7.14.0</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-junit-platform-engine</artifactId>
    <version>7.14.0</version>
    <scope>test</scope>
</dependency>
```

## Step 2: Project Structure Setup

Create the following directory structure:
```
src/test/
├── java/
│   └── edu/citadel/
│       └── cucumber/
│           ├── CucumberSpringConfiguration.java
│           ├── RunCucumberTest.java
│           └── stepdefinitions/
│               └── ApiStepDefinitions.java
└── resources/
    └── features/
        └── api_tests.feature
```

## Step 3: Configure Cucumber Test Runner

Create `src/test/java/edu/citadel/cucumber/RunCucumberTest.java`:
- Use `@Suite` and `@IncludeEngines("cucumber")`
- Configure `@SelectClasspathResource("features")`
- Set `@ConfigurationParameter` for plugin and glue

## Step 4: Configure Spring Context

Create `src/test/java/edu/citadel/cucumber/CucumberSpringConfiguration.java`:
- Use `@SpringBootTest` with webEnvironment
- Use `@CucumberContextConfiguration`
- Configure test profile if needed

## Step 5: Write Feature File

Create `src/test/resources/features/api_tests.feature`:
- Write 3 scenarios, one for each endpoint you're testing
- Use Given/When/Then format
- Example structure:
  ```gherkin
  Feature: API Endpoint Testing

    Scenario: Test GET endpoint returns data
      Given the application is running
      When I send GET request to "/api/endpoint"
      Then the response status should be 200
      And the response should contain expected data
  ```

## Step 6: Implement Step Definitions

Create `src/test/java/edu/citadel/cucumber/stepdefinitions/ApiStepDefinitions.java`:
- Use `@Autowired` for TestRestTemplate or MockMvc
- Implement @Given, @When, @Then methods matching your feature file
- Store response state for verification
- Use assertions (JUnit or AssertJ)

## Step 7: Test Your Implementation

```bash
# Build the project
./mvnw clean install

# Run Cucumber tests
./mvnw test

# Or run specific Cucumber test
./mvnw test -Dtest=RunCucumberTest
```

Fix any failing tests or configuration issues.

## Checklist Before Submission

- [ ] All 3 Cucumber scenarios written and passing
- [ ] Tests cover actual endpoint functionality
- [ ] All tests pass: `./mvnw test`

## Troubleshooting Tips

**Build fails**: Check Maven dependencies and versions
**Tests not found**: Verify package structure and glue configuration
**Spring context fails**: Check @CucumberContextConfiguration and test profile
**Feature file not found**: Verify path in @SelectClasspathResource

## Reference Resources

- Cucumber Tutorial: https://cucumber.io/docs/guides/10-minute-tutorial/
- Cucumber-Spring: https://github.com/cucumber/cucumber-jvm/tree/main/cucumber-spring
- Spring Boot Testing: https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.testing
