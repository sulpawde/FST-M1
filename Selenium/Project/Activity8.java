package activities;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity8 {

	// Declare the WebDriver object
	WebDriver driver;
	// Create the Wait object
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		// Set up the Firefox driver
		WebDriverManager.firefoxdriver().setup();
		//Create a new instance of the Firefox driver
		driver = new FirefoxDriver();
		// Create the Wait object
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//Open browser
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	}


	@Test 
	public void backEndLogin() {
		//Find the username and password fields
		WebElement username = driver.findElement(By.id("user_login"));
		WebElement password = driver.findElement(By.id("user_pass"));

		//Enter credentials
		username.sendKeys("root");
		password.sendKeys("pa$$w0rd");

		//Click login
		driver.findElement(By.id("wp-submit")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()=\"Dashboard\"]"))); 
		
		Assert.assertEquals("Dashboard ‹ Alchemy Jobs — WordPress",  driver.getTitle());
	}

	
	@AfterClass
	public void tearDown() {
		//Close the browser
		driver.quit();
	}
}