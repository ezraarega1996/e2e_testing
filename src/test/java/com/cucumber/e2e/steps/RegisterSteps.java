package com.cucumber.e2e.steps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitUntilState;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

// ExampleSteps.java
@SpringBootTest
public class RegisterSteps {
    @Autowired
    private PlaywrightSession playwrightSession;

    @Given("I navigate to the signup page")
    public void iNavigateToTheSignupPage() {
        playwrightSession.getPage().navigate("http://localhost:3000", new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));
    }

    @When("I enter the following details:")
    public void iEnterTheFollowingDetails(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        playwrightSession.getPage().fill("input[name='firstName']", data.get("firstName"));
        playwrightSession.getPage().fill("input[name='middleName']", data.get("middleName"));
        playwrightSession.getPage().fill("input[name='lastName']", data.get("lastName"));
        playwrightSession.getPage().fill("input[name='email']", data.get("email"));
        playwrightSession.getPage().fill("input[name='password']", data.get("password"));
        playwrightSession.getPage().fill("input[name='role']", data.get("role"));
    }
    @When("I click the {string} button")
    public void iClickTheButton(String buttonText) {
        //playwrightSession.getPage().click(String.format("text=%s", buttonText));
        playwrightSession.getPage().waitForNavigation(() -> {
            playwrightSession.getPage().click(String.format("text=%s", buttonText));
        });
    }

    @Then("I should see the user detail page")
    public void iShouldSeeTheLoginPage() {

        playwrightSession.getPage().waitForLoadState(LoadState.LOAD);
        //playwrightSession.getPage().waitForURL("http//localhost:3001");
        // Get the current page URL
        String currentUrl = playwrightSession.getPage().url();

        // Assert that the current URL matches the expected login page URL
        Assertions.assertEquals("http://localhost:3000/menu", currentUrl);
    }
}
