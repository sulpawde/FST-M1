package stepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FirstExample extends BaseClass {

	@Given ("the user is on the TS homepage")
	public void openTSHomePage() {
		//Open the page
		driver.get("https://v1.training-support.net/");
		System.out.println(driver.getTitle());
		Assertions.assertEquals("Training Support",  driver.getTitle());

	}

	@When ("the user click on homepage")
	public void clickAboutLink() {
		driver.findElement(By.id("about-link")).click();

	}
	@Then ("the user is redirected to the About page")
	public void verifyAboutPage() {
		Assertions.assertEquals(driver.getTitle(), "About Training Support");
		System.out.println(driver.getTitle());
	}

}
