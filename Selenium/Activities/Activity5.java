package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Download the Geckodriver
		WebDriverManager.firefoxdriver().setup();

		//Initialize the Firefox driver
		WebDriver driver = new FirefoxDriver();


		// Open the page
		driver.get("https://v1.training-support.net/selenium/login-form");
		// Print the title of the page
		System.out.println("Home page title: " + driver.getTitle());

		// Find the username field and enter the username
		driver.findElement(By.id("username")).sendKeys("admin");
		// Find the password field and enter the password
		driver.findElement(By.id("password")).sendKeys("password");
		// Find the login button and click it
		driver.findElement(By.xpath("//button[text()='Log in']")).click();

		// Print the confirmation message
		String message = driver.findElement(By.id("action-confirmation")).getText();
		System.out.println("Login message: " + message);

		// Close the browser
		//driver.close();

	}
}
