import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;

public class StaticPageTest {

    // Static Page test
    
    private WebDriver driver;
    private StaticPage staticPage;

    @Before
    public void setUp() throws MalformedURLException {
        driver = DriverSetup.getWebDriver();
        staticPage = new StaticPage(driver);
    }

    @Test
    public void testStaticPages() {
        String errorInPage = staticPage.loadAndVerifyPages();

        Assert.assertTrue("Page verification failed for the path: " + errorInPage, errorInPage.isEmpty());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
