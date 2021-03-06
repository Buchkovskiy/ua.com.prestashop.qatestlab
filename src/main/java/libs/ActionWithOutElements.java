package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionWithOutElements {
    WebDriver webDriver;
    Actions action;

    Logger logger = Logger.getLogger(getClass());


    public ActionWithOutElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        action = new Actions(webDriver);

    }

    public void enterTextToInput(WebElement element, String text) {
        try {
            element.sendKeys(text);
            logger.info("Text was inputed");
        } catch (Exception e) {
            logger.error("Text can't inputed");
            Assert.fail("Text can't inputed");
        }

    }

    public void clickToElement(WebElement element) {
        try {
            element.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            logger.error("Element can't clicked");
            Assert.fail("Element can't clicked");
        }
    }

    public void clickToElement(String locator) {
        try {
            clickToElement(webDriver.findElement(By.xpath(locator)));

        } catch (Exception e) {
            logger.error("Can't work with element");
            Assert.fail("Can't work with element");
        }
    }




    public boolean isDisplayed(WebElement element) {
        try {
            return  element.isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDisplayed(String locator) {
        try {
            return isDisplayed(webDriver.findElement(By.xpath(locator)));
        } catch (Exception e) {
            return false;
        }
    }


    public void moveToElement(WebElement element) {
        try {
            action.moveToElement(element).perform();
            logger.info("Element was moved");
        } catch (Exception e) {
            logger.error("Element can't moved");
            Assert.fail("Element can't moved");
        }
    }

}
