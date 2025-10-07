Feature: REST API Endpoint Testing

  Scenario: Test health endpoint returns ok status
    Given the application is running
    When I send GET request to "/health"
    Then the response status should be 200
    And the response should contain field "status" with value "ok"

  Scenario: Test info endpoint returns application information
    Given the application is running
    When I send GET request to "/info"
    Then the response status should be 200
    And the response should contain field "name"
    And the response should contain field "version"
    And the response should contain field "description"

  Scenario: Test account endpoint returns 404 for non-existent account
    Given the application is running
    When I send GET request to "/account/99999"
    Then the response status should be 404
