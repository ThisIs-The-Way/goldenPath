import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;


public class GoldenPathBase {
    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get("https://www.shirtspace.com/t-shirts");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void closeBrowser() {
        driver.manage().deleteAllCookies();
        driver.close();
    }

    public void waitForElement(By elementToWait) {
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOfElementLocated(elementToWait);
        new WebDriverWait(driver, 10).until(condition);
    }

    public void clickButton(By elementToClick){
        driver.findElement(elementToClick).click();
    }

    public void sendKey(By elementWhereToSend, String textToSend){
        driver.findElement(elementWhereToSend).sendKeys(textToSend);
    }

    public void verify(By elementToVerify){
        WebElement element = driver.findElement(elementToVerify);
        boolean displayed = element.isDisplayed();
        Assert.assertTrue(displayed);
    }
}
