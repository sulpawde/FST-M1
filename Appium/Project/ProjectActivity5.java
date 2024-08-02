//Goal: Opening a page on the browser and testing a simple login page with correct & Incorrect credentials

package AppiumProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ProjectActivity5 {

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
	public void testCorrectCredentialsLoginFormCard(){
	    // Scroll to find the Login Form card and click it
       driver.findElement(By.xpath("//android.widget.FrameLayout[@contentDesc='Login Form']")).click();

        // Find the username and password input fields and enter the correct credentials
        WebElement usernameField = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='username']"));
        usernameField.sendKeys("admin");
        WebElement passwordField = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='password']"));
        passwordField.sendKeys("password");

        // Click on the Log in button to submit
        WebElement loginButton = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Log in']"));
        loginButton.click();

        // Verify the correct message appears
        WebElement messageElement = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='You are logged in']"));
        Assert.assertTrue(messageElement.isDisplayed());
    }
	
	@Test
	public void testIncorrectCredentialsLoginFormCard(){
	    // Scroll to find the Login Form card and click it
       driver.findElement(By.xpath("//android.widget.FrameLayout[@contentDesc='Login Form']")).click();

        // Find the username and password input fields and enter the correct credentials
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='username']")).sendKeys("wrongadmin");
        
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='password']")).sendKeys("wrongpassword");

        // Click on the Log in button to submit
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Log in']")).click();

        // Verify the incorrect message appears
        WebElement messageElement = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Invalid username or password']"));
        Assert.assertTrue(messageElement.isDisplayed());
        
	}
}