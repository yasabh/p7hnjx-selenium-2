import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class LoginTest {

    // Fill simple form and send (eg. Login)

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() throws MalformedURLException {
        driver = DriverSetup.getWebDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testInvalidLogin() {
        loginPage.enterValidUsername(); // Fill input (text,radio,check...)
        loginPage.enterPassword("invalidpassword"); // Fill input (text,radio,check...)
        loginPage.clickLoginButton(); // Send a form

        String error = loginPage.getErrorMessage();
        Assert.assertTrue("Error message not displayed as expected", error.contains("enter a correct username/email and password"));
    }

    @Test
    public void testValidLoginAndLogout() {
        loginPage.enterValidUsername(); // Fill input (text,radio,check...)
        loginPage.enterValidPassword(); // Fill input (text,radio,check...)
        loginPage.clickLoginButton(); // Send a form

        Assert.assertTrue("Error login", loginPage.isLoggedIn());

        // loginPage.hoverOverProfile(); // Hover test
        loginPage.clickLogoutButton(); // Logout
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
