import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import java.net.MalformedURLException;

public class SettingTest {

    private WebDriver driver;
    private SettingPage settingPage;

    @Before
    public void setUp() throws MalformedURLException {
        driver = DriverSetup.getWebDriver();
        settingPage = new SettingPage(driver);
    }

    @Test
    public void testUpdateProfile() {
        settingPage.enterValidUsername(); // Fill input (text,radio,check...)
        settingPage.enterValidPassword(); // Fill input (text,radio,check...)
        settingPage.clickLoginButton(); // Send a form

        // String avatarPath = System.getProperty("user.dir") + "/src/resources/images/batman.png";
        // settingPage.uploadImage(avatarPath); // File Upload

        settingPage.enterDisplayName("Yasin Abdullah"); // Fill input (text,radio,check...)
        settingPage.selectCountry("Indonesia"); // Filling or reading drop-down
        settingPage.enterAboutMe("P7HNJX - Big Selenium Project"); // Filling or reading textarea content
        settingPage.clickSaveButton(); // Send a form

        String succesMessage = settingPage.getSuccessMessage();
        Assert.assertTrue("Profile update failed to execute", succesMessage.contains("You have successfully updated your profile."));
    }

    @Test
    public void testManipulateCookiesWithJavaScript() {
        // JavascriptExecutor
        // Manipulate cookie meaningfully (without ui), e.g. avoid showing up consent popup without clicking onto it
        ZonedDateTime now = ZonedDateTime.now(java.time.ZoneOffset.UTC);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.cookie = 'customCookie=P7HNJX; path=/;';");
        js.executeScript("document.cookie = 'OptanonAlertBoxClosed=" + now.format(formatter) + "; path=/;';");
        driver.navigate().refresh();

        Assert.assertTrue("Error manipulating cookie", !settingPage.isApprearingAcceptAllCookieButton());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
