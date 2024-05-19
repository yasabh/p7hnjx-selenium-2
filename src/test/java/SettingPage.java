import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SettingPage extends LoginPage {

    protected static final String PATH = "/settings";

    private By displayNameInput = By.xpath("//input[@name='full_name']"); // complex xpath (eg. //div//a[@href='asd'])
    private By countrySelect = By.xpath("//select[@name='country']"); // complex xpath (eg. //div//a[@href='asd'])
    private By aboutMeInput = By.xpath("//textarea[@name='about_me']"); // complex xpath (eg. //div//a[@href='asd'])
    private By saveButton = By.xpath("//form[@name='profile-form']//button[@type='submit']"); // complex xpath (eg. //div//a[@href='asd'])
    private By successAlert = By.xpath("//div[@class='alert alert-success']"); // complex xpath (eg. //div//a[@href='asd'])
    private By profileAvatar = By.xpath("//a[@class='masthead-search-toggle']"); // complex xpath (eg. //div//a[@href='asd'])
    private By profileDropdown = By.xpath("//div[@id='auth-dropdown']"); // complex xpath (eg. //div//a[@href='asd'])

    public SettingPage(WebDriver driver) {
        super(driver);
        loadPage(this.BASE_URL + PATH);
    }

    public void enterDisplayName(String displayName) {
        WebElement element = waitAndReturnElement(displayNameInput);
        element.clear();
        element.sendKeys(displayName);
    }

    public void selectCountry(String country) {
        selectFromDropdown(countrySelect, country);
    }

    public void enterAboutMe(String aboutMe) {
        WebElement element = waitAndReturnElement(aboutMeInput);
        element.clear();
        element.sendKeys(aboutMe);
    }

    public void clickSaveButton() {
        waitAndReturnElement(saveButton).click();
    }

    public String getSuccessMessage() {
        return waitAndReturnElement(successAlert).getText();
    }

    public void hoverOverProfileAvatar(){
        hoverOverElement(saveButton);
    }

    public void dragAndDropText(){
        dragAndDropText(displayNameInput, aboutMeInput);
    }
}
