package activities;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity6 {

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
		driver.get("https://alchemy.hguy.co/jobs/");
	}
	
	 @Test
	    public void applyforJob() {
		//click on jobs link
	        driver.findElement(By.linkText("Jobs")).click();
	        Assert.assertEquals("Jobs – Alchemy Jobs", driver.getTitle());
	        
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_keywords")));
	        driver.findElement(By.id("search_keywords")).sendKeys("Banking");
	        
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class=\"job_listings\"]/li[1]/a")));
	        driver.findElement(By.xpath("//ul[@class=\"job_listings\"]/li[1]/a")).click();
	        
	        wait.until(ExpectedConditions.visibilityOfElementLocated (By.xpath("//input[@value=\"Apply for job\"]")));
		    driver.findElement(By.xpath("//input[@value=\"Apply for job\"]")).click();
		    
	        System.out.println("email id captured is " + driver.findElement(By.xpath("//a[@class=\"job_application_email\"]")).getText());
	    	}
	     

	@AfterClass
	public void tearDown() {
		//Close the browser
		driver.quit();
	}
}