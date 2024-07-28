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
    # pageTitle = driver.title

    print("Page title is : ", driver.title)

    pageHeading = driver.find_element(By.XPATH, "//h1[contains(@class, 'entry-title')]")
    pageHead = pageHeading.text
    print("Heading of the page: ", pageHeading.text)

if pageHead == "Welcome to Alchemy Jobs":
    driver.quit()
else:
    print("Heading mismatch")