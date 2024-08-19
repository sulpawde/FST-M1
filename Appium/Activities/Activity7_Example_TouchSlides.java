import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity7_Example_TouchSlides extends W3CActionBase {
	AndroidDriver driver;
	WebDriverWait wait;


	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {
		//Desired capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();
		URL serverURL = new URI("http://127.0.0.1:4723").toURL();

		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Open the page in Chrome
		driver.get("https://v1.training-support.net/selenium/sliders");
	}

	@Test
	public void swipeTest() {
		// Get dimensions of screen
		Dimension dims = driver.manage().window().getSize();

		// Wait for the page to load
		wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View")));

		// Set start and end points
		Point start = new Point((int)(dims.width*0.35), (int)(dims.height*0.5));
		Point end = new Point((int)(dims.width*0.5), (int)(dims.height*0.5));
		// Perform swipe on slider
		W3CActionBase.doSwipe(driver, start, end, 250);

		// Get text on page and assert
		String volumeLevel = driver.findElement(AppiumBy.xpath("//android.widget.SeekBar[@resource-id = 'slider']/preceding-sibling::android.view.View")).getText();
		Assert.assertEquals(volumeLevel, "Volume Level: 50%");
	}

	@AfterClass
	public void afterClass() {
		// Close the browser
		driver.quit();
	}
}