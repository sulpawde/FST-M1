import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {
	// Driver Declaration
	AndroidDriver driver;

	// Set up method
	@BeforeClass
	public void setUp() throws MalformedURLException {

		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		//options.setAppPackage("com.android.calculator2");
		//options.setAppActivity(".Calculator");
		options.setAppPackage("com.google.android.calculator");
		options.setAppActivity("com.android.calculator2.Calculator");
		options.noReset();

		// Server Address
		@SuppressWarnings("deprecation")
		URL serverURL = new URL("http://localhost:4723/");

		driver = new AndroidDriver(serverURL, options);
	}

	// Test method
	@Test
	public void multiplyTest() {
		// Perform the calculation
		driver.findElement(AppiumBy.id("digit_5")).click();
		driver.findElement(AppiumBy.accessibilityId("multiply")).click();
		driver.findElement(AppiumBy.id("digit_8")).click();
	    driver.findElement(AppiumBy.accessibilityId("equals")).click();
	    
		// Find the result
		String result = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText();

		// Assertion
		Assert.assertEquals(result, "40");
	}


	// Tear down method
	@AfterClass
	public void tearDown() {
		// Close the app
		driver.quit();
	}
}