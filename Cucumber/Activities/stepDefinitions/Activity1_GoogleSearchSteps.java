package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity1_GoogleSearchSteps extends BaseClass {

	@Given("^User is on Google Home Page$")
	public void userIsOnGooglePage() throws Throwable {
		//Open the browser
		driver.get("https://www.google.com");
	}

	@When("^User types in Cheese and hits ENTER$")
	public void userTypesInCheeseAndHitsENTER() throws Throwable {
		driver.findElement(By.name("q")).sendKeys("Cheese", Keys.RETURN);
	}

	@Then("^Show how many search results were shown$")
	public void showHowManySearchResultsWereShown() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h3[contains(text(),\"Cheese\")]")));
		Thread.sleep(5000);
		int resultStats = driver.findElements(By.xpath("//h3[contains(text(),\"Cheese\")]")).size();
		System.out.println("Number of results found: " + resultStats);
	}

}