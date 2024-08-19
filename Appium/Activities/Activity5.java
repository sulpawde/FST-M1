
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity5 {
	AndroidDriver driver;
	WebDriverWait wait;


	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.apps.messaging");
		options.setAppActivity(".ui.LaunchConversationListActivity");
		options.noReset();

	 	URL serverURL = new URI("http://127.0.0.1:4723").toURL();
			driver = new AndroidDriver(serverURL, options);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}
	
	
	@Test
	public void messagingTest() throws Exception
	{
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Start chat\"]")).click();
		  // Wait for elements to load
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ContactSearchField\")")));		
		
        WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ContactSearchField\")"));
        
        if (!element.isDisplayed() || !element.isEnabled()) {
            System.out.println("Element is not visible or enabled");
        }
        
        element.click();
        element.sendKeys("7304956973");

		driver.pressKey(new KeyEvent(AndroidKey.ENTER));

		driver.findElement(AppiumBy.id("compose_message_text")).sendKeys("Hello From Appium");
		driver.findElement(AppiumBy.accessibilityId("Send SMS")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
		Thread.sleep(3000);

		String sentmsg= driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.apps.messaging:id/conversation_snippet\"]")).getText();
		Assert.assertEquals(sentmsg, "You: Hello From Appium");	
	}

	// Tear down method
	@AfterClass
	public void tearDown() {
		// Close the app
		driver.quit();
	}

}