import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import org.openqa.selenium.By;


class PageBase {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected Actions actions;
    protected static final String BASE_URL;
    protected static final Config config = new Config();

    static {
        BASE_URL = config.getProperty("base.url");
    }

    private By acceptCookieButton = By.xpath("//button[@id='onetrust-accept-btn-handler']"); // complex xpath (eg. //div//a[@href='asd'])
    
    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, config.getPropertyAsInt("timeout")); // Explicit wait
        this.actions = new Actions(driver);
    }

    protected void loadPage(String url){
        driver.get(url);
        clickAcceptAllCookie();
    }
   
    private void clickAcceptAllCookie() {
        try{
            waitAndReturnElement(acceptCookieButton).click();
        } catch (NoSuchElementException | TimeoutException e) {
            // skip it
        }
    }

    public boolean isApprearingAcceptAllCookieButton() {
        try{
            return waitAndReturnElement(acceptCookieButton) != null;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    
    protected WebElement waitAndReturnElement (By locator) throws NoSuchElementException {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void selectFromDropdown(By locator, String valueToSelect) {
        Select dropdown = new Select(this.waitAndReturnElement(locator));
        dropdown.selectByVisibleText(valueToSelect);
    }
    
    public void hoverOverElement(By locator) {
        WebElement element = waitAndReturnElement(locator);
        actions.moveToElement(element).perform();
    }
    
    // public void dragAndDropText(By locator, By elementLocated) {
    //     WebElement element = this.driver.findElement(locator);
    //     WebElement element1 = this.driver.findElement(elementLocated);
    //     actions.dragAndDrop(element, element1)
    //         .perform();
    // }
    
    // public void clickDropdownOption(By dropdownLocator, By optionLocator) {
    //     waitAndReturnElement(dropdownLocator).click();
    //     wait.until(ExpectedConditions.elementToBeClickable(optionLocator)).click();
    // }

}
