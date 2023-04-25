package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart() {
//* Mouse Hover on Gear Menu
        mouseHoverOnElement(By.xpath("//span[normalize-space()='Gear']"));
//* Click on Bags
        clickOnElement(By.xpath("//span[contains(text(),'Bags')]"));
//* Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[contains(text(),'Overnight Duffle')]"));
//* Verify the text ‘Overnight Duffle’
        String expectedMessage = "Overnight Duffle";
        String actualMessage = getTextFromElement(By.xpath("//span[contains(text(),'Overnight Duffle')]"));
        Assert.assertEquals(expectedMessage, actualMessage);
        //* Change Qty 3
        sendKeysToElement(By.xpath("//input[@id='qty']"), "3");

        //* Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//span[contains(text(),'Add to Cart')]"));

//* Verify the text ‘You added Overnight Duffle to your shopping cart.’
        String expectedMessage1 = "You added Overnight Duffle to your shopping cart.";
        String actualMessage1 = getTextFromElement(By.xpath("//body/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]"));
        Assert.assertEquals(expectedMessage1, actualMessage1);


        //* Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));


        //* Verify the product name ‘Cronus Yoga Pant’
        String expectedMessage2 = "Cronus Yoga Pant";
        String actualMessage2 = getTextFromElement(By.xpath("//tbody[1]/tr[1]/td[1]/div[1]/strong[1]/a[1]"));
        Assert.assertEquals(expectedMessage2, actualMessage2);

        //* Verify the Qty is ‘3’
        String expectedMessage3 = "3";
        String actualMessage3 = getTextFromElement(By.xpath("//input[@id='cart-106590-qty']"));
        Assert.assertEquals(expectedMessage3, actualMessage3);

        //* Verify the product price ‘$135.00’
        String expectedMessage4 = "$135.00";
        String actualMessage4 = getTextFromElement(By.xpath("//span[contains(text(),'$135.00')]"));
        Assert.assertEquals(expectedMessage4, actualMessage4);
        //* Change Qty to ‘5’
        sendKeysToElement(By.xpath("//input[@id='cart-106590-qty']"), "5");

        //* Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[contains(text(),'Update Shopping Cart')]"));

        //* Verify the product price ‘$225.00’
        String expectedMessage5 = "$225.00";
        String actualMessage5 = getTextFromElement(By.xpath("//span[contains(text(),'$225.00')]"));
        Assert.assertEquals(expectedMessage5, actualMessage5);
    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}
