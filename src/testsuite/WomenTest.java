package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class WomenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() {
//       * Mouse Hover on Women Menu
        clickOnMouseHoverOnElement(By.xpath("//span[normalize-space()='Women']"));

//        * Mouse Hover on Tops
        mouseHoverOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[2]"));

//        * Click on Jackets
        clickOnMouseHoverOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));


//        * Select Sort By filter “Product Name”
        selectByVisibleTextFromDropDown(By.id("sorter"), "Product Name");

//        * Verify the products name display in
//        alphabetical order
        assertProduct("Adrienne Trek Jacket", 1);
        assertProduct("Augusta Pullover Jacket ", 2);
        assertProduct("Inez Full Zip Jacket ", 3);
        assertProduct("Ingrid Running Jacket ", 4);
        assertProduct("Jade Yoga Jacket ", 5);
        assertProduct("Josie Yoga Jacket ", 6);
        assertProduct(" Juno Jacket ", 7);
        assertProduct(" Juno Jacket ", 8);
        assertProduct("Neve Studio Dance Jacket ", 9);
        assertProduct("Augusta Pullover Jacket ", 10);
        assertProduct("Inez Full Zip Jacket ", 11);
        assertProduct("Ingrid Running Jacket ", 12);


    }

    @Test
    public void verifyTheSortByPriceFilter() {

//        Mouse Hover on Women Menu
        clickOnMouseHoverOnElement(By.xpath("//span[normalize-space()='Women']"));
//        * Mouse Hover on Tops
        mouseHoverOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[2]"));


//        * Click on Jackets
        clickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));

//        * Select Sort By filter “Price”
        selectByVisibleTextFromDropDown(By.id("sorter"), "Price ");

//        * Verify the products price display in
//        Low to High
        assertPrice("$32.00", 1);
        assertPrice("$56.25", 2);
        assertPrice("$57.00", 3);
        assertPrice("$57.00", 4);
        assertPrice("$59.00", 5);
        assertPrice("$60.00", 6);
        assertPrice("$69.00", 7);
        assertPrice("$69.00", 8);
        assertPrice("$77.00", 9);
        assertPrice("$77.00", 10);
        assertPrice("$77.00", 11);
        assertPrice("$84.00", 12);


    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}
