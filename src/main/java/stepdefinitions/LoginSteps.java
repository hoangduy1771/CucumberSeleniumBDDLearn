package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginSteps {

    static final Logger logger = LogManager.getLogger(LoginSteps.class);

    @Given("User is on login page")
    public void userIsOnLoginPage() {
        // Write code here that turns the phrase above into concrete actions
        logger.info("Step - User is on login page - success");
    }
    @When("User enters userName and passWord")
    public void userEntersUserNameAndPassword() {
        // Write code here that turns the phrase above into concrete actions
        logger.info("Step - User enters userName and passWord - success");
    }
    @When("User clicks on login button")
    public void clicksOnLoginButton() {
        // Write code here that turns the phrase above into concrete actions
        logger.info("Step - User clicks on login button");
    }
    @Then("User can navigate to the homepage")
    public void userCanNavigateToTheHomepage() {
        // Write code here that turns the phrase above into concrete actions
        logger.info("Step - User can navigate to the homepage");
    }


}
