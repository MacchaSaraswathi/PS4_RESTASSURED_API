package stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_StepDefinition {

    private String baseUrl;
    private Response response;

    @Given("API valid URI {string} is up")
    public void setBaseUrl(String uri) {
        baseUrl = uri;
    }

    @When("I make a GET request for {string}")
    public void makeGetRequest(String endpoint) {
        RequestSpecification request = RestAssured.given();
        response = request.get(baseUrl + "/2018/" + endpoint);
    }

    @Then("the response status code should be {int}")
    public void verifyStatusCode(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        assertEquals("Status code not as expected", expectedStatusCode, actualStatusCode);
    }

    @Then("the response body should contain data of {string}")
    public void verifyResponseBody(String expectedBody) {
        String responseBody = response.getBody().asString();
        System.out.println("Response Body:");
        System.out.println(responseBody);
        assertTrue("Response body does not contain expected data", responseBody.contains(expectedBody));
    }
}