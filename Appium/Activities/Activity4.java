import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity4 {
    // Driver Declaration
    AndroidDriver driver;
    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.dialer");
        options.setAppActivity(".extensions.GoogleDialtactsActivity");
        options.noReset();

    	URL serverURL = new URI("http://127.0.0.1:4723").toURL();
		driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Test method
    @Test
    public void contactsTest() {
        // Find and click the add button
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.dialer:id/contact_name\" and @text=\"Create new contact\"]")).click();

        
        // Wait for elements to load
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Show detailed name fields\"]")));
        
        
        // Open Name details
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Show detailed name fields\"]")).click();

        
        // Wait for elements to load
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("com.samsung.android.app.contacts:id/firstEdit")
        ));

        // Enter the details
        driver.findElement(AppiumBy.id(
                "com.samsung.android.app.contacts:id/firstEdit"
        )).sendKeys("Aaditya");
       
        
        // Wait for elements to load
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("com.samsung.android.app.contacts:id/lastEdit")
        ));
        
        driver.findElement(AppiumBy.id("com.samsung.android.app.contacts:id/lastEdit")).sendKeys("Varma");
    
        // Hide name details
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Hide detailed name fields\"]")).click();

        
        // Wait for elements to load
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("(//android.widget.LinearLayout[@resource-id=\"com.samsung.android.app.contacts:id/editor_item_frame\"])[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup")));
        
        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout[@resource-id=\"com.samsung.android.app.contacts:id/titleLayout\"])[1]")).click();
        	     
        
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Phone']")).sendKeys("999148292");
   
        // Click Save
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.samsung.android.app.contacts:id/navigation_bar_item_small_label_view\" and @text=\"Save\"]")).click();

        // Wait for contact to save
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.samsung.android.app.contacts:id/header")));

        // Assertion
        String contactName = driver.findElement(AppiumBy.id("com.samsung.android.app.contacts:id/header")).getText();
        Assert.assertEquals(contactName, "Aaditya Varma");
    }

    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}