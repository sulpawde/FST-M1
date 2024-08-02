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

public class ProjectActivity1 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void addGoogleTasks() {

        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";

        driver.findElement(AppiumBy
                .xpath("//android.widget.ImageButton[@content-desc=\"Create new task\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));

        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Tasks");

        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

        driver.findElement(AppiumBy
                .xpath("//android.widget.ImageButton[@content-desc=\"Create new task\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));

        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Keep");

        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

        driver.findElement(AppiumBy
                .xpath("//android.widget.ImageButton[@content-desc=\"Create new task\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));

        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete the second Activity Google Keep");

        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

        String firstTask =  driver.findElement(AppiumBy.androidUIAutomator("text(\"Complete Activity with Google Tasks\")")).getText();

        System.out.println(firstTask);

        Assert.assertEquals(firstTask, "Complete Activity with Google Tasks");

        String secondTask =  driver.findElement(AppiumBy.androidUIAutomator("text(\"Complete Activity with Google Keep\")")).getText();

        System.out.println(secondTask);

        Assert.assertEquals(secondTask, "Complete Activity with Google Keep");

        String thirdTask =  driver.findElement(AppiumBy.androidUIAutomator("text(\"Complete the second Activity Google Keep\")")).getText();

        System.out.println(thirdTask);

        Assert.assertEquals(thirdTask, "Complete the second Activity Google Keep");

    }

}