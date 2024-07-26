package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
		driver.get("https://v1.training-support.net");
	}

	@Test (priority=0)
	public void homepageTest() {
		//Assertion for page title
		Assert.assertEquals("Training Support",  driver.getTitle());
		//Find the clickable link on the page and click it
		driver.findElement(By.id("about-link")).click();
	}
	
	@Test (priority=1)
	public void aboutpageTest() {
		//Assertion for page title
		Assert.assertEquals(driver.getTitle(), "About Training Support");
	}

	@AfterClass
	public void tearDown() {
		//Close the browser
		driver.quit();
	}
}