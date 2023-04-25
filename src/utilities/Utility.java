package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    public void selectMenu(String menu) {
        clickOnElement(By.linkText(menu));
    }

    public void clickOnElement(By by) {
        // This method will click on element
        driver.findElement(by).click();
    }

    // This method will get text from element
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    // This method will get WebElement from element
    public WebElement getWebElement(By by) {
        return driver.findElement(by);
    }

    // select class for dropdown list
    public void selectByVisibleTextFromDropDown(By by, String visibleText) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(visibleText);


    }

    // This method to help entering text in text box
    public void sendKeysToElement(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    public String getAttributeValueFromElement(By by) {
        return driver.findElement(by).getAttribute("value");
    }

    public void dismissAlert() {
        Alert alert = driver.switchTo().alert(); // Creating alert Object reference and Switch to Alert
        System.out.println(alert.getText()); // Getting the text from alert
        // alert.accept(); // Accepting the alert
        alert.dismiss();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void assertProduct(String expectedProduct, int index) {
        String expectedProduct1 = expectedProduct;
        String actualProduct1 = getTextFromElement(By.xpath("(//ol//strong//a)[" + index + "]"));
        Assert.assertEquals(expectedProduct1, actualProduct1);
    }

    public void assertPrice(String expectedProduct, int index) {
        String expectedProduct1 = expectedProduct;
        String actualProduct1 = getTextFromElement(By.xpath("(//div[@class='products wrapper grid products-grid']//span[@class='price'])[" + index + "]"));
        Assert.assertEquals(expectedProduct1, actualProduct1);
    }

    public void mouseHoverOnElement(By by) {
        Actions actions = new Actions(driver);
        WebElement xyz = driver.findElement(by);
        actions.moveToElement(xyz).build().perform();
    }

    public void clickOnMouseHoverOnElement(By by) {
        Actions actions = new Actions(driver);
        WebElement xyz = driver.findElement(by);
        actions.moveToElement(xyz).click().build().perform();
    }

}
