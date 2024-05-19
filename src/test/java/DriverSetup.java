import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverSetup {

    public static WebDriver getWebDriver() throws MalformedURLException {
        Config config = new Config();
        ChromeOptions options = new ChromeOptions();

        String[] chromeOptions = config.getPropertyAsArray("chrome.options");
        for (String option : chromeOptions) {
            options.addArguments(option);
        }

        WebDriver driver = new RemoteWebDriver(new URL(config.getProperty("webdriver.chrome.driver")), options);
        driver.manage().window().maximize();
        return driver;
    }
}