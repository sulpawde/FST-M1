from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.select import Select
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service1 = FirefoxService(GeckoDriverManager().install())


# Start the Driver
with webdriver.Firefox(service=service1) as driver:
    job_title = "Selenium Python Developer"
    job_location = "Pune"
    job_type = "Freelance"
    job_descr = "We are seeking a skilled Selenium Python Developer to join our team. \n"
    job_post_email = "sul1@ibm.com"

    # set implicit wait time
    driver.implicitly_wait(10) # seconds

    # Open the browser to the URL
    driver.get("https://alchemy.hguy.co/jobs")
    title = driver.title

    print("Page title is : ", driver.title)

    driver.find_element(By.LINK_TEXT, "Post a Job").click()

    driver.find_element(By.XPATH, "//input[@id='create_account_email']").send_keys(job_post_email)

    driver.find_element(By.ID, "job_title").send_keys(job_title)

    driver.find_element(By.ID, "job_location").send_keys(job_location)

    driver.find_element(By.ID, "job_description_ifr").send_keys(job_descr)

    driver.find_element(By.XPATH, "//input[@id='application']").send_keys(job_post_email)

    driver.find_element(By.ID, "company_name").send_keys("IBM")

    driver.find_element(By.NAME, "submit_job").click()

    driver.find_element(By.ID, "job_preview_submit_button").click()
  
    driver.find_element(By.XPATH, "//a[text()='click here']").click()
    job = driver.find_element(By.XPATH, "//h1[contains(@class, 'entry-title')]")
    jobTitle = job.text

    assert jobTitle == job_title
    print("job Title Posted is : ",job.text)


