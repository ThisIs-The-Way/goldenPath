import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoldenPath extends GoldenPathBase{

    public void verifyPurchase() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//a[contains(text(),'Gildan G200 Adult Ultra Cotton® 6 oz. T-Shirt–Blac')]")));
        removeItem();
        verifyThatCartIsEmpty();
    }

    public void verifyThatCartIsEmpty() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//a[contains(text(),'Continue Shopping')]")));
    }

    public void removeItem() {
        driver.findElement(By.xpath("//a[contains(text(),'Remove')]")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }


    public void buyTShirt() {
        waitForMainPage();//wait for the page to loud
        driver.findElement(By.xpath("//div[@data-product-id='1230']")).click();//select item
        waitForItem();
        driver.findElement(By.xpath("//input[@id='M']")).sendKeys("23");//select a quantity
        driver.findElement(By.xpath("//button[@id='add-to-cart']")).click();//add to cart
        waitForConfirmButton();
        driver.findElement(By.xpath("//a[@class='button button--cconfirm primary-button-v3']")).click();//view cart/checkout
    }

    private void waitForConfirmButton() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//a[@class='button button--cconfirm primary-button-v3']")));
    }

    public void singIn(){
        //press sing in button
        driver.findElement(By.xpath("//div[@class='header-account__link-container']")).click();
        waitForEmail();

        //enter email and password
        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("0969229149@mail.ru");
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("a969229149");
        driver.findElement(By.xpath("//input[@class='primary-button-v3']")).click();//press sign in button
    }


    public void waitForEmail(){
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='user_email']")));
    }

    public void waitForMainPage(){
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-product-id='1230']")));
    }

    private void waitForItem() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='M']")));
    }
}
