package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Download the Geckodriver
				WebDriverManager.firefoxdriver().setup();
				
				//Initialize the Firefox driver
				WebDriver driver = new FirefoxDriver();
				
				//Open a new browser to https://v1.training-support.net/selenium/target-practice
				
				driver.get("https://v1.training-support.net/selenium/target-practice");
				
				//Get the title of the page and print it to the console
				
				System.out.println("Title of the page : " + driver.getTitle());
					
				//Find the 3rd header on the page and print it's text to the console
				
				System.out.println(driver.findElement(By.xpath("//h3[@id='third-header']")).getText());
				
				//Find the 5th header on the page and print it's color
				
				System.out.println(driver.findElement(By.xpath("//h5[text()='Fifth header']")).getCssValue("color"));
			
				//Find the violet button and print all it's classes
				
				System.out.println(driver.findElement(By.xpath("//button[text()='Violet']")).getAttribute("class"));
				
			
				//Find the grey button and print it's text
				System.out.println(driver.findElement(By.xpath("//button[text()='Grey']")).getText());
				
				
				//Close the browser
				driver.quit();
				
				
}
}