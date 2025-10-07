package edu.citadel.cucumber.stepdefinitions;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiStepDefinitions {

    @Autowired
    private TestRestTemplate restTemplate;

    private ResponseEntity<String> response;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Given("the application is running")
    public void theApplicationIsRunning() {
        // The application is already running due to @SpringBootTest
        assertNotNull(restTemplate, "TestRestTemplate should be initialized");
    }

    @When("I send GET request to {string}")
    public void iSendGETRequestTo(String endpoint) {
        response = restTemplate.getForEntity(endpoint, String.class);
    }

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int expectedStatus) {
        assertNotNull(response, "Response should not be null");
        assertEquals(expectedStatus, response.getStatusCode().value(),
                "Expected status code " + expectedStatus + " but got " + response.getStatusCode().value());
    }

    @And("the response should contain field {string} with value {string}")
    public void theResponseShouldContainFieldWithValue(String fieldName, String expectedValue) throws Exception {
        assertNotNull(response.getBody(), "Response body should not be null");
        JsonNode jsonNode = objectMapper.readTree(response.getBody());
        assertTrue(jsonNode.has(fieldName), "Response should contain field: " + fieldName);
        assertEquals(expectedValue, jsonNode.get(fieldName).asText(),
                "Field " + fieldName + " should have value " + expectedValue);
    }

    @And("the response should contain field {string}")
    public void theResponseShouldContainField(String fieldName) throws Exception {
        assertNotNull(response.getBody(), "Response body should not be null");
        JsonNode jsonNode = objectMapper.readTree(response.getBody());
        assertTrue(jsonNode.has(fieldName), "Response should contain field: " + fieldName);
        assertNotNull(jsonNode.get(fieldName), "Field " + fieldName + " should not be null");
    }
}
