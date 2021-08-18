import org.testng.annotations.Test;


public class GoldenPathTest extends GoldenPath {

    @Test
    public void test() { //name for test -- should by 1 item
        openBrowser();
        singIn();
        buyTShirt();
        verifyPurchase(); //here should be assert

/*
        @Test 2        
        public void test() { should remove 1 item            
            openBrowser();            
            singIn();           
            buyTShirt();            
            removePurshaseFromBag(); this will incude -- removeItem(); verifyThatCartIsEmpty(); you have them      
           verifyPurchase(); //here should be assert -- with empty bag 
        
        @Test 3
        should test diff type of users


           */
    }
}
