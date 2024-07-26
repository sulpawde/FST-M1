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

public class Activity4 {

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
	    public void verifyHeading2() {
		//Get the heading2 of the webpage.
	        WebElement heading2 = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/h2"));
	        Assert.assertEquals(heading2.getText(), "Quia quis non");
	    	
	    }
	     

	@AfterClass
	public void tearDown() {
		//Close the browser
		driver.quit();
	}
}