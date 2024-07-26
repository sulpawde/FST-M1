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

public class Activity7 {

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
	public void createNewJobListing() {
		//click on jobs link
		driver.findElement(By.linkText("Post a Job")).click();
		Assert.assertEquals("Post a Job – Alchemy Jobs", driver.getTitle());
		WebElement heading1 = driver.findElement(By.xpath("//h1[@class = \"entry-title\"]"));
		Assert.assertEquals(heading1.getText(), "Post a Job");
		driver.findElement(By.xpath("//a[text()=\"Sign in\"]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginform")));  
	}

	@Test (enabled = true, dependsOnMethods = {"createNewJobListing"})
	public void loginTest() {
		//Find the username and password fields
		WebElement username = driver.findElement(By.id("user_login"));
		WebElement password = driver.findElement(By.id("user_pass"));

		//Enter credentials
		username.sendKeys("root");
		password.sendKeys("pa$$w0rd");

		//Click login
		driver.findElement(By.id("wp-submit")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='field account-sign-in']"))); 
	}

	@Test (enabled = true, dependsOnMethods = {"loginTest"})
	public void fillAndPostJob() {
		
		String jobTitle = "Selenium Java Developer";
		String jobLocation = "Pune";
		String jobType = "Freelance";
		String jobDescr = "We are seeking a skilled Selenium Java Developer to join our team. "
				+ "As a Selenium Java Developer, you will be responsible for designing, developing, "
				+ "and testing automated tests for our web application using Selenium WebDriver "
				+ "and Java. You will work closely with our QA team to ensure that our application "
				+ "meets the highest standards of quality and functionality.\r\n"
				+ "";
		String jobPostEmail = "sul@ibm.com";

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("job_title")));
		driver.findElement(By.id("job_title")).sendKeys(jobTitle);

		driver.findElement(By.id("job_location")).sendKeys(jobLocation);
		WebElement jobTypeDDL = driver.findElement(By.id("job_type"));
		Select select = new Select(jobTypeDDL);
		select.selectByVisibleText(jobType);

		WebElement jobDescriptionFld = driver.findElement(By.id("job_description_ifr"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].contentWindow.document.body.innerHTML = arguments[1];",jobDescriptionFld, jobDescr);
		
		WebElement emailFld = driver.findElement(By.xpath("//input[@id=\"application\"]"));
		emailFld.clear();
		emailFld.sendKeys(jobPostEmail);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit_job")));
		
		driver.findElement(By.name("submit_job")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()=\"Preview\"]")));
		
		driver.findElement(By.id("job_preview_submit_button")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\"click here\"]")));
		
		driver.findElement(By.xpath("//a[text()=\"click here\"]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class =\"site-description\"]")));
		
	    String actualJobPostTitle = driver.findElement(By.tagName("h1")).getText();
		
		Assert.assertEquals(actualJobPostTitle, jobTitle);
	}


	@AfterClass
	public void tearDown() {
		//Close the browser
		driver.quit();
	}
}