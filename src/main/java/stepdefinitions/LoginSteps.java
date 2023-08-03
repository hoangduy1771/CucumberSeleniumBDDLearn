package stepdefinitions;

import base.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class LoginSteps {
    static final Logger logger = LogManager.getLogger(LoginSteps.class);
    WebDriver driver;

    @Given("User navigate to {string} with {string}")
    public void userIsOnLoginPage(String url, String browserType) {

        switch (browserType.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            default:
        }

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.get(url);
    }

    @When("User enters {} and {}")
    public void userEntersUserNameAndPassword(String userName, String passWord) {
        driver.findElement(By.id("name")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(passWord);

        logger.info("Step - User enters userName and passWord - success");
    }
    @When("User clicks on login button")
    public void clicksOnLoginButton() {
        driver.findElement(By.id("login")).click();

        logger.info("Step - User clicks on login button");
    }
    @Then("User can navigate to the homepage")
    public void userCanNavigateToTheHomepage() {
        driver.findElement(By.id("logout")).isDisplayed();

        logger.info("Step - User can navigate to the homepage");
        driver.close();
    }


}
