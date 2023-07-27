
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/main/java/features",
        glue={"stepdefinitions"},
        plugin = {"pretty"},
        tags = "@test",
        monochrome = true
)
public class TestRunner {

}
