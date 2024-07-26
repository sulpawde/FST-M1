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

public class Activity2 {

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
	    public void verifyHeading1() {
		//Get the heading1 of the webpage.
	        WebElement heading1 = driver.findElement(By.xpath("//h1[@class = \"entry-title\"]"));
	        Assert.assertTrue(heading1.isDisplayed());
	        Assert.assertEquals(heading1.getText(), "Welcome to Alchemy Jobs");
	    }
	     

	@AfterClass
	public void tearDown() {
		//Close the browser
		driver.quit();
	}
}