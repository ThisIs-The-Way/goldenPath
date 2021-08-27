import org.testng.annotations.Test;
//1. Sing In and verify
//2. Add item to the cart and verify purchase
//3. Delete item from the card and verify that card is empty

public class GoldenPathTest extends GoldenPath {

    @Test //1. Sing In and verify
    public void test1(){
        singIn();
        verifyAction();
    }


    @Test //2. Add item to the card and verify purchase
    public void test2(){
        buyTShirt();
        verifyPurchase();
    }

    @Test //3. Delete item from the card and verify that card is empty
    public void test3(){
        removeItem();
        verifyThatCartIsEmpty();
    }
}
