import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {

    protected static final String PATH = "/login";

    private By usernameInput = By.xpath("//input[@name='username_or_email']"); // complex xpath (eg. //div//a[@href='asd'])
    private By passwordInput = By.xpath("//input[@name='password']"); // complex xpath (eg. //div//a[@href='asd'])
    private By loginButton = By.xpath("//button[@name='submit']"); // complex xpath (eg. //div//a[@href='asd'])
    private By logoutButton = By.xpath("//form[@action='/logout']//button"); // complex xpath (eg. //div//a[@href='asd'])
    private By profileImage = By.xpath("//a[@aria-controls='auth-dropdown']"); // complex xpath (eg. //div//a[@href='asd'])
    private By errorMessage = By.xpath("//div[@class='alert alert-danger']"); // complex xpath (eg. //div//a[@href='asd'])

    public LoginPage(WebDriver driver) {
        super(driver);
        loadPage(this.BASE_URL + PATH);
    }

    public void enterValidUsername() {
        enterUsername(config.getProperty("username"));
    }

    public void enterValidPassword() {
        enterPassword(config.getProperty("password"));
    }

    public void enterUsername(String username) {
        waitAndReturnElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        waitAndReturnElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        waitAndReturnElement(loginButton).click();
    }

    public void hoverOverProfile() {
        hoverOverElement(profileImage);
    }

    public void clickLogoutButton() {
        waitAndReturnElement(logoutButton).click();
    }

    public boolean isLoggedIn() {
        try{
            return waitAndReturnElement(profileImage) != null;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public String getErrorMessage() {
        return waitAndReturnElement(errorMessage).getText();
    }
}
