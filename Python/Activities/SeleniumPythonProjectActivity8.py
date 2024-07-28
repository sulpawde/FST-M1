# Set up the Firefox Driver with WebDriverManger
from selenium import webdriver
from selenium.webdriver.common.by import By
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService

service1 = FirefoxService(GeckoDriverManager().install())


# Start the Driver
with webdriver.Firefox(service=service1) as driver:

    driver.get("https://alchemy.hguy.co/jobs/wp-admin")

    driver.find_element(By.ID, "user_login").send_keys("root")

    driver.find_element(By.ID, "user_pass").send_keys("pa$$w0rd")

    driver.find_element(By.ID, "wp-submit").click()

    pageTitle = driver.title

    print("Title of the page: ", pageTitle)

    assert pageTitle == "Dashboard ‹ Alchemy Jobs — WordPress"

    
