package activities;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
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

public class Activity9 {

	// Declare the WebDriver object
	WebDriver driver;
	// Create the Wait object
	WebDriverWait wait;
	String jobTitle = "Selenium Java Developer";
	String jobLocation = "Pune";
	String jobType = "Freelance";
	String jobPostEmail = "sul@ibm.com";
	String jobCompany = "IBMTest";


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

	@Test (enabled = true, dependsOnMethods = {"backEndLogin"})
	public void createJobListing() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=\"Job Listings \"]"))); 
		driver.findElement(By.xpath("//div[text()=\"Job Listings \"]")).click();	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"page-title-action\"]"))); 
		driver.findElement(By.xpath("//a[@class=\"page-title-action\"]")).click();
		driver.findElement(By.xpath("//button[@aria-label=\"Close dialog\"]")).click();

		driver.findElement(By.id("post-title-0")).sendKeys(jobTitle);
		driver.findElement(By.id("_job_location")).sendKeys(jobLocation);
		driver.findElement(By.id("_application")).clear();
		driver.findElement(By.id("_application")).sendKeys(jobPostEmail);
		driver.findElement(By.id("_company_name")).sendKeys(jobCompany);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"edit-post-header__settings\"]//button[contains(text(),\"Publish\")]")));
		
		driver.findElement(By.xpath("//div[@class=\"edit-post-header__settings\"]//button[contains(text(),\"Publish\")]")).click();
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class= \"components-button editor-post-publish-button editor-post-publish-button__button is-primary\"]")));
				
		driver.findElement(By.xpath("//*[@class= \"components-button editor-post-publish-button editor-post-publish-button__button is-primary\"]")).click();
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".post-publish-panel__postpublish-header > a:nth-child(1)")));
	
		Assert.assertEquals(jobTitle, driver.findElement(By.cssSelector(".post-publish-panel__postpublish-header > a:nth-child(1)")).getText());

		driver.findElement(By.cssSelector(".post-publish-panel__postpublish-header > a:nth-child(1)")).click();
		
		Assert.assertEquals(jobTitle,driver.findElement(By.cssSelector(".entry-title")).getText());
		
	}
		
		@AfterClass
		public void tearDown() {
			//Close the browser
			driver.quit();
		}
	}