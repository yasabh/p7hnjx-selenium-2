import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StaticPage extends PageBase {

    protected static final String[] PATHS = {
        "/dashboard",
        "/music",
        "/charts",
        "/events",
        "/features"
    };

    private String expectedTitle = "last.fm";

    public StaticPage(WebDriver driver) {
        super(driver);
    }

    public String loadAndVerifyPages() {
        for (String PATH : PATHS) {
            loadPage(this.BASE_URL + PATH);

            if (!driver.getTitle().toLowerCase().contains(expectedTitle)) { // Reading the page title
                return PATH;
            }
        }

        return "";
    }
}
