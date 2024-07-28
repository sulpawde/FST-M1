from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service1 = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service1) as driver:
    # Open the browser to the URL
    driver.get("https://alchemy.hguy.co/jobs")
    pageTitle = driver.title

    print("Page title is : ", driver.title)

if pageTitle == "Alchemy Jobs – Job Board Application":
    driver.quit()
else:
    print("Title mismatch")