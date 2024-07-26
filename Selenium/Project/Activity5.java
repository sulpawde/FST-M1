package activities;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity5 {

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
	    public void verifyJobdPageTitle() {
		//click on jobs link
	        driver.findElement(By.linkText("Jobs")).click();
	        Assert.assertEquals("Jobs – Alchemy Jobs", driver.getTitle());
	    	}
	     

	@AfterClass
	public void tearDown() {
		//Close the browser
		driver.quit();
	}
}