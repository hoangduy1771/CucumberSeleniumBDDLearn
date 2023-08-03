package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


//extends UIInteractions
public class GoogleSearchSteps {

    WebDriver driver;

    @Given("User open browser")
    public void userOpenBrowser() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

//        Serenity.getWebdriverManager().closeAllDrivers();
//        driver.quit();


    }
    @Given("User navigate to Google")
    public void userNavigateToGoogle() {
        driver.get("https://www.google.com/?hl=en");

    }
    @When("User enters text in the search box")
    public void userEntersTextInTheSearchBox() {
        driver.findElement(By.name("q")).sendKeys("What time is it?");

    }
    @When("User click {string} button in Google")
    public void userClickButton(String buttonName) throws InterruptedException {
        String googleButtonXpath = String.format("//div[@class='FPdoLc lJ9FBc']//input[@value='%s']", buttonName);
        String googleHiddenButtonXpath = String.format("//input[@value='%s']", buttonName);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement googleButton = driver.findElement(By.xpath(googleHiddenButtonXpath));
        wait.until(ExpectedConditions.visibilityOf(googleButton));

        googleButton.click();

    }
    @Then("User can view the results")
    public void userCanViewTheResults() {
        driver.getPageSource().contains("Time in Ho Chi Minh City");
        driver.close();
    }

}
