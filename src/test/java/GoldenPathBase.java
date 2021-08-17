import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

public class GoldenPathBase {
    WebDriver driver;

    public void openBrowser() {
        driver = new FirefoxDriver();
        driver.get("https://www.shirtspace.com/t-shirts");
    }

    @AfterClass
    public void closeBrowser() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
