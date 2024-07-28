# Set up the Firefox Driver with WebDriverManger
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService
import time

service1 = FirefoxService(GeckoDriverManager().install())


# Start the Driver
with webdriver.Firefox(service=service1) as driver:

    job_title = "Selenium Python Developer"
   
    # set implicit wait time
    driver.implicitly_wait(10) # seconds

    driver.get("https://alchemy.hguy.co/jobs/wp-admin")

    driver.find_element(By.ID, "user_login").send_keys("root")

    driver.find_element(By.ID, "user_pass").send_keys("pa$$w0rd")

    driver.find_element(By.ID, "wp-submit").click()

    pageTitle = driver.title

    print("Title of the page: ", pageTitle)

    assert pageTitle == "Dashboard ‹ Alchemy Jobs — WordPress"

    driver.find_element(By.XPATH, "//div[text()='Job Listings ']").click()

    driver.find_element(By.XPATH, "//a[contains(@class, 'page-title-action')]").click()

    driver.find_element(By.XPATH, "//button[text()='Next']").click()
    driver.find_element(By.XPATH, "//button[text()='Next']").click()
    driver.find_element(By.XPATH, "//button[text()='Next']").click()

    driver.find_element(By.XPATH, "//button[contains(@class, 'components-button components-guide__finish-button is-primary')]").click()

    driver.find_element(By.XPATH, "//textarea[@id='post-title-0']").send_keys(job_title)
    time.sleep(3)  
 
    driver.find_element(By.XPATH, "//input[@id='_job_location']").send_keys("Pune")
    time.sleep(3)

    driver.find_element(By.XPATH, "//button[text()='Publish…']").click()
    time.sleep(3)

    driver.find_element(By.XPATH, "//button[text()='Publish']").click()
    time.sleep(3)

    driver.find_element(By.XPATH, "//a[contains(@class, 'components-button is-secondary')]").click()
    time.sleep(3)  

    Title = driver.find_element(By.XPATH, "//h1[contains(@class, 'entry-title')]")

    print("Entry title: ", Title.text)

    entryTitle = Title.text

    assert entryTitle == "Testor"
