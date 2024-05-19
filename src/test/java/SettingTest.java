import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

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
        settingPage.enterUsername("p7hnjx"); // Fill input (text,radio,check...)
        settingPage.enterPassword("c@nLog1n"); // Fill input (text,radio,check...)
        settingPage.clickLoginButton(); // Send a form

        settingPage.enterDisplayName("Yasin Abdullah"); // Fill input (text,radio,check...)
        settingPage.selectCountry("Indonesia"); // Filling or reading drop-down
        settingPage.enterAboutMe("P7HNJX - Big Selenium Project"); // Filling or reading textarea content
        settingPage.clickSaveButton(); // Send a form

        settingPage.dragAndDropText(); // Hover test

        String succesMessage = settingPage.getSuccessMessage();
        Assert.assertTrue("Profile update failed to execute", succesMessage.contains("You have successfully updated your profile."));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
