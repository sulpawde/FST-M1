package testRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/Features",
		glue = {"stepDefinitions"},
		monochrome=true,
		tags = "@activity3",
		publish = true,
		plugin = {
				"pretty",
				"html:src/reports/HTML_Report.html",
				"json:src/reports/HTML_Report.json",
				"junit:src/reports/HTML_Report.xml"
		},
		dryRun = false
				
)

public class Activity3Runner {
    //empty
}