package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity1 {

	// Declare the WebDriver object
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		// Set up the Firefox driver
		WebDriverManager.firefoxdriver().setup();
		//Create a new instance of the Firefox driver
		driver = new FirefoxDriver();
		//Open browser
		driver.get("https://alchemy.hguy.co/jobs/");
	}
	
  

	@Test 
	public void verifyHomePageTitle() {
		//Verify the website title
		Assert.assertEquals("Alchemy Jobs – Job Board Application",  driver.getTitle());
	
	}

	@AfterClass
	public void tearDown() {
		//Close the browser
		driver.quit();
	}
}