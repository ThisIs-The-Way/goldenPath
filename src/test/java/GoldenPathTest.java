import org.testng.annotations.Test;


public class GoldenPathTest extends GoldenPath {

    @Test
    public void test() {
        openBrowser();
        singIn();
        buyTShirt();
        verifyPurchase();
    }
}
