package AppiumProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ProjectActivity2 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void addNoteGoogleKeep(){
        driver.findElement(AppiumBy
                .xpath("//android.widget.ImageButton[@content-desc=\"New text note\"]"))
                .click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy
                .id("com.google.android.keep:id/editable_title")));
        driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title"))
                .sendKeys("Google note");
        driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text"))
                .sendKeys("Notes can be added");
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy
        .id("com.google.android.keep:id/index_note_title")));
        String note = driver.findElement(AppiumBy.id("com.google.android.keep:id/index_note_title"))
                .getText();

        Assert.assertEquals(note, "Google note");
    }

}