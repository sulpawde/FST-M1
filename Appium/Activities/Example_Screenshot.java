import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Example_Screenshot {

	static AndroidDriver driver;

	@BeforeClass
	public void setup() throws MalformedURLException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.calculator");
		options.setAppActivity("com.android.calculator2.Calculator");
		options.noReset();

		URL serverUrl = new URL("http://localhost:4723/");

		driver = new AndroidDriver(serverUrl, options);
	} 

	public static void takeScreenShot() throws IOException
	{

		File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // Take screenshot
		File newscreenShotFile=new File("src/test/resources/ScreenShot/screenshot.jpg");// This specifies the location the screenshot will be saved
		FileUtils.copyFile(srcFile, newscreenShotFile);// This will copy the screenshot to the file created
		String filePath = "../" + newscreenShotFile ;// Set filepath for image
		String path = "<img src='" + filePath + "'/>";// Set image HTML in the report
		Reporter.log(path); // Show image in report

	}

	@Test
	public void multipyTest() throws Exception
	{
		driver.findElement(AppiumBy.id("digit_9")).click();
		driver.findElement(AppiumBy.accessibilityId("multiply")).click();

		driver.findElement(AppiumBy.id("digit_5")).click();

		driver.findElement(AppiumBy.id("eq")).click();
		takeScreenShot();
		String finalResult= driver.findElement(AppiumBy.id("result_final")).getText();
		System.out.println("result is :"+finalResult);

	}

	// Tear down method
	@AfterClass
	public void tearDown() {
		// Close the app
		driver.quit();
	}


}