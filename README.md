# Selenium Project

## Configuration

This project uses a `config.properties` file for configuration settings. Make sure to create this file in the project root directory with the following content:

```properties
# config.properties

# Webdriver settings
webdriver.chrome.driver=http://selenium:4444/wd/hub

# Browser options
# Using configuration file
# WebDriver configuration (modify something in the browser options)
# --headless : Run Chrome in headless mode (without a GUI).
chrome.options=--headless

# Test settings
base.url=https://www.example.com
username=valid_username
password=valid_password

# Other settings
timeout=10