Feature: Testing GET request to ergast API for F1 circuits

  Scenario Outline: GET data from F1 circuit of 2018
    Given API valid URI "https://ergast.com/api/f1" is up
    When I make a GET request for "circuits.json"
    Then the response status code should be 200
    And the response body should contain data of "circuits.json"