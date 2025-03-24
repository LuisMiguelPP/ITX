package com.luismi.itx.ecommerce.cucumber.e2e;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@CucumberContextConfiguration
public class PriceStepDefinitions extends CucumberSpringConfiguration{



    private ResponseEntity<String> response;

    @Given("the application is running")
    public void theApplicationIsRunning() {
        assertNotNull(restTemplate); // Verifica que la aplicación está corriendo
    }

    @When("I send a request to {string} with:")
    public void iSendARequestToWith(String endpoint, io.cucumber.datatable.DataTable dataTable) {
        var row = dataTable.asMaps().getFirst();
        String applicationDate = row.get("applicationDate");
        String productId = row.get("productId");
        String brandId = row.get("brandId");

        String url = String.format("%s?applicationDate=%s&productId=%s&brandId=%s",
                endpoint, applicationDate, productId, brandId);
        response = restTemplate.getForEntity(url, String.class);
    }

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int status) {
        assertEquals(status, response.getStatusCode().value());
    }

    @Then("the response should contain:")
    public void theResponseShouldContain(io.cucumber.datatable.DataTable dataTable) {
        var rows = dataTable.asMaps();
        rows.forEach(row -> {
            String field = row.get("field");
            String value = row.get("value");
            assertTrue(response.getBody().contains(String.format("\"%s\":%s", field, value)));
        });
    }
}
