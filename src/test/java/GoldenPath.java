import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoldenPath extends GoldenPathBase{

    public void singIn(){
        //press sing in button
        clickButton(By.xpath("//div[@class='header-account__link-container']"));
        waitForElement(By.xpath("//input[@id='user_email']"));

        //enter email and password
        sendKey(By.xpath("//input[@id='user_email']"), "0969229149@mail.ru");
        sendKey(By.xpath("//input[@id='user_password']"), "a969229149");
        clickButton(By.xpath("//input[@class='primary-button-v3']"));//press sign in button
    }

    public void verifyAction() {
        waitForElement(By.xpath("//div[@data-product-id='1230']"));
        verify(By.xpath("//div[@data-product-id='1230']"));
    }

    public void buyTShirt() {
        //waitForElement(By.xpath("//div[@data-product-id='1230']"));//wait for the page to loud
        clickButton(By.xpath("//div[@data-product-id='1230']"));//select item
        waitForElement(By.xpath("//input[@id='M']"));
        sendKey(By.xpath("//input[@id='M']"), "23");//select a quantity
        clickButton(By.xpath("//button[@id='add-to-cart']"));//add to cart
        waitForElement(By.xpath("//a[@class='button button--cconfirm primary-button-v3']"));
        clickButton(By.xpath("//a[@class='button button--cconfirm primary-button-v3']"));//view cart/checkout
    }

    public void verifyPurchase() {
        waitForElement(By.xpath("//a[contains(text(),'Gildan G200 Adult Ultra Cotton® 6 oz. T-Shirt–Blac')]"));
        verify(By.xpath("//a[contains(text(),'Gildan G200 Adult Ultra Cotton® 6 oz. T-Shirt–Blac')]"));
    }

    public void removeItem() {
        clickButton(By.xpath("//a[contains(text(),'Remove')]"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void verifyThatCartIsEmpty() {
        waitForElement(By.xpath("//a[contains(text(),'Continue Shopping')]"));
    }

}
