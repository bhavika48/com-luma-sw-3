package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart() throws InterruptedException {
        //* Mouse Hover on Men Menu
        clickOnMouseHoverOnElement(By.xpath("//a[@id='ui-id-5']"));
        //        * Mouse Hover on Bottoms
        mouseHoverOnElement(By.linkText("Bottoms"));
        //  * Click on Pants
        clickOnMouseHoverOnElement(By.xpath("//a[contains(text(),'Pants')]"));

        //* Mouse Hover on product name 'Cronus Yoga Pant’ and click on size 32
        mouseHoverOnElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
        clickOnElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));

        // * Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour  Black.

        //mouseHooverToElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
        clickOnElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]"));

        //* Mouse Hover on product name Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.

        mouseHoverOnElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
        clickOnElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/button[1]/span[1]"));
        // * Verify the text
        //‘You added Cronus Yoga Pant to your shopping cart.’
        String expMessage = "You added Cronus Yoga Pant to your shopping cart.";
        String actualMessage = getTextFromElement(By.xpath("(//div[@role='alert']//div)[2]"));
        Assert.assertEquals(expMessage, actualMessage);
        //  * Click on ‘shopping cart’ Link into  message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        // * Verify the product name ‘Cronus Yoga Pant’
        String expMessage1 = "Cronus Yoga Pant";
        String actualMessage1 = getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));
        Assert.assertEquals(expMessage1, actualMessage1);

        //Verify the product size ‘32’
        String expMessage2 = "32";
        String actualMessage2 = getTextFromElement(By.xpath("//dd[contains(text(),'32')]"));
        Assert.assertEquals(expMessage2, actualMessage2);

        //* Verify the product colour ‘Black’
        String expMessage3 = "Black";
        String actualMessage3 = getTextFromElement(By.xpath("//dd[contains(text(),'Black')]"));
        Assert.assertEquals(expMessage3, actualMessage3);


    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
