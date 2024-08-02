//Goal: Opening a page on the browser and testing a to-do list page 


package AppiumProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class ProjectActivity4 {

	AndroidDriver driver;

	WebDriverWait wait;

	@BeforeClass
	public void setUp() throws MalformedURLException {

		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UIAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();

		URL serverURL = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver(serverURL, options);

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://v1.training-support.net/selenium");

	}

	@Test
	public void TodoListTest(){
		String UiScrollable = "UiScrollable(UiSelector().Scrollable(true))";

		wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View")));

		driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollForward()"));

		// Scroll to find the To-Do List card and click it.
		driver.findElement(By.xpath("//android.widget.FrameLayout[@contentDesc='To-Do List']")).click();

		// Enter the three tasks
		WebElement inputField = driver.findElement(AppiumBy.xpath("//android.widget.EditText"));
		inputField.sendKeys("Add tasks to list");
		inputField.sendKeys("\nGet number of tasks");
		inputField.sendKeys("\nClear the list");

		// Verify the number of tasks
		int numTasks = Integer.parseInt(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Number of tasks:']")).getText().split(":")[1].trim());
		Assert.assertEquals(numTasks, 3);

		// Click on each task to strike it out
		List<WebElement> taskElements = driver.findElements(AppiumBy.xpath("//android.widget.TextView"));
		for (WebElement taskElement : taskElements) {
			taskElement.click();
		}

		// Verify that all tasks are struck out
		for (WebElement taskElement : taskElements) {
			Assert.assertTrue(taskElement.getAttribute("class").contains("strike-through"));
		}

		// Clear the list
		inputField.sendKeys("\n");
		inputField.sendKeys("\n");
		inputField.sendKeys("\n");

		// Verify that the list is empty
		Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Number of tasks:']")).getText(), "Number of tasks: 0");
	}
}
