from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service1 = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service1) as driver:
    # Open the browser to the URL
    driver.get("https://alchemy.hguy.co/jobs")
    title = driver.title

    print("Page title is : ", driver.title)

    driver.find_element(By.XPATH,"//a[text()='Jobs']").click()
    print("Title of the Jobs menu page: ", driver.title)
    jobsPageTitle = driver.title

    assert jobsPageTitle == "Jobs – Alchemy Jobs"
