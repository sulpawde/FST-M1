from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service1 = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service1) as driver:

    wait = WebDriverWait(driver, 10)

    # Open the browser to the URL
    driver.get("https://alchemy.hguy.co/jobs")
    title = driver.title

    print("Page title is : ", driver.title)

    driver.find_element(By.XPATH, "//a[text()='Jobs']").click()
    print("Title of the Jobs menu page: ", driver.title)
    jobsPageTitle = driver.title

    assert jobsPageTitle == "Jobs – Alchemy Jobs"

    driver.find_element(By.XPATH, "//input[@id='search_keywords']").send_keys("Banking")
    driver.find_element(By.XPATH, "//input[@type='submit']").click()

    driver.find_element(By.XPATH, "//h3[text()='Banking'][1]").click()

    driver.find_element(By.XPATH, "//input[contains(@class, 'application_button button')]").click()

    Email = driver.find_element(By.XPATH, "//a[contains(@class, 'job_application_email')]")
    print("Contact email: ", Email.text)



