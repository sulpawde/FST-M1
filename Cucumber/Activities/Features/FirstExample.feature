
@FirstExample
Feature: feature1

  @FirstScenario @SmokeTest
  Scenario: Basic test for selenium
    Given the user is on the TS homepage
    When the user click on homepage
    Then the user is redirected to the About page
  