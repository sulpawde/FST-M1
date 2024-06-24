package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity7 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Download the Geckodriver
		WebDriverManager.firefoxdriver().setup();

		//Initialize the Firefox driver
		WebDriver driver = new FirefoxDriver();

		Actions builder = new Actions(driver);
		
		// Open a new browser to https://v1.training-support.net/selenium/drag-drop
		driver.get("https://v1.training-support.net/selenium/drag-drop");

		// Get the title of the page and print it to the console.
		System.out.println("The title of the page : " + driver.getTitle());

		// On the page, perform:
		// Find the ball and simulate a click and drag to move it into "Dropzone 1".


		driver.findElement(By.id("draggable"));		
		driver.findElement(By.id("droppable"));
		driver.findElement(By.id("dropzone2"));
		
		builder.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();

		// Verify that the ball has entered Dropzone 1.
		
		Thread.sleep(5000);
		
		// Once verified, move the ball into "Dropzone 2".

		builder.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("dropzone2"))).build().perform();

		// Verify that the ball has entered Dropzone 2.

		// Find the football
        WebElement football = driver.findElement(By.id("draggable"));
        // Find the dropzone1
        WebElement dropzone1 = driver.findElement(By.id("droppable"));
        // Find the dropzone2
        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));
		
		// Perform drag and drop to dropzone 1
        builder.clickAndHold(football).moveToElement(dropzone1).pause(2000).release().build().perform();
       
        // Verify that the ball was dropped in dropzone 1
        String dropzone1Verify = dropzone1.findElement(By.tagName("p")).getText();
        if(dropzone1Verify.equals("Dropped!")) {
            System.out.println("Ball was dropped in dropzone 1");
        }

        // Perform drag and drop to dropzone 2
        builder.dragAndDrop(football, dropzone2).build().perform();
        // Verify that the ball was dropped in dropzone 2
        String dropzone2Verify = dropzone2.findElement(By.tagName("p")).getText();
        
        if(dropzone2Verify.equals("Dropped!")) {
            System.out.println("Ball was dropped in dropzone 2");
		
		//Close the browser
		driver.quit();

	}
}
}
