package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Download the Geckodriver
		WebDriverManager.firefoxdriver().setup();

		//Initialize the Firefox driver
		WebDriver driver = new FirefoxDriver();

		// Open a new browser to https://v1.training-support.net/selenium/selects
		driver.get("https://v1.training-support.net/selenium/selects");

		// Get the title of the page and print it to the console.
		System.out.println("Title of the page : " + driver.getTitle());

		WebElement selectElement  = driver.findElement(By.id("multi-select"));
		
		Select multiSelect = new Select(selectElement);
		
		// On the Multi Select:
		// Select the "JavaScript" option using the visible text.
		multiSelect.selectByVisibleText("Javascript");
		
		// Select the 4th, 5th and 6th options using the index.
		multiSelect.selectByIndex(4);
		multiSelect.selectByIndex(5);
		multiSelect.selectByIndex(6);
		
		
		// Select the "NodeJS" option using the value.
		multiSelect.selectByValue("node");
		
		// Print the selected options
        List<WebElement> selectedOptions = multiSelect.getAllSelectedOptions();
        
        System.out.println("Selected options are: ");
        for(WebElement option : selectedOptions) {
            System.out.println(option.getText());
        }
		
		// Deselect the 5th option using index.
		multiSelect.deselectByIndex(5);
		
		 // Print the selected options
        selectedOptions = multiSelect.getAllSelectedOptions();
        System.out.println("Selected options are: ");
        for(WebElement option : selectedOptions) {
            System.out.println(option.getText());
        }
		
		// Close the browser.

		driver.quit();

	}
}