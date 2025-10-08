package edu.citadel.main;

import edu.citadel.main.CucumberSpringConfiguration;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.springframework.http.HttpStatusCode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;


public class UserStepDefinitions extends CucumberSpringConfiguration{
    @When("^the client calls /info")
    public void the_client_issues_GET_version() throws Throwable{
        executeGet(createURLWithPort("/info"));
    }

    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        HttpStatusCode currentStatusCode = latestResponse.getStatusCode();
        assertThat("status code is incorrect : "+
                latestResponse.getBody(), currentStatusCode.value(), is(statusCode));
    }

    @And("^the client receives server version (.+)$")
    public void the_client_receives_server_version_body(String expectedVersion) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree(latestResponse.getBody().toString());
        String actualVersion = json.get("version").asText();
        assertThat(actualVersion, is(expectedVersion));
    }

    @And("^the client receives server name (.+)$")
    public void the_client_receives_server_name_body(String expectedName) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree(latestResponse.getBody().toString());
        String actualName = json.get("name").asText();
        assertThat(actualName, is(expectedName));
    }

    @And("^the client receives server description (.+)$")
    public void the_client_receives_server_description_body(String expectedDescription) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree(latestResponse.getBody().toString());
        String actualDescription = json.get("description").asText();
        assertThat(actualDescription, is(expectedDescription));
    }


    public class StepDefs extends CucumberSpringConfiguration {

        @When("^the client calls /info")
        public void the_client_issues_GET_version() throws Throwable {
            executeGet("http://localhost:8080/version");
        }
    }
}
