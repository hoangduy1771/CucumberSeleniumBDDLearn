
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/main/java/features",
        glue={"stepdefinitions"},
        plugin = {"pretty",
                "junit:target/JUnitReports/report.xml",
                "json:target/JSONReports/report.json",
                "html:target/htmlReports"
        },
        tags = "@test",
        monochrome = true
)
public class TestRunner {

}
