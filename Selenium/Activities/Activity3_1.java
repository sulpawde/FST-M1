package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity3_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Download the Geckodriver
				WebDriverManager.firefoxdriver().setup();
				
				//Initialize the Firefox driver
				WebDriver driver = new FirefoxDriver();
				
				//Open the page
				driver.get("https://v1.training-support.net/");
				
				//Verify the page title
				System.out.println("Page title is: " + driver.getTitle());
				
				
				//Interactions
				//Find the "About Us" button on the page using it's id.

				WebElement aboutLinkelement =  driver.findElement(By.xpath("//a[text()='About Us']"));
			
				//Click on that button
				aboutLinkelement.click();

				System.out.println(driver.getCurrentUrl());

				//Get the title of the new page and print it to the console
				System.out.println("Page title is: " + driver.getTitle());
				
				//Close the browser
				//driver.quit();
				
}
}
