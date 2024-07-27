package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testBeforAfterSetup extends BaseClass{

	@Before
	public static void setUp() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}



	@And("^Close the browser$")
	public void closeTheBrowser() throws Throwable {
	driver.quit();	
	}

}
