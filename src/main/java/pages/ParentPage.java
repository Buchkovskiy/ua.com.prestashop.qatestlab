package pages;

import libs.ActionWithOutElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import java.util.regex.Pattern;

abstract public class ParentPage {
    WebDriver webDriver;
    Action action;

    Logger logger = Logger.getLogger(getClass());
    ActionWithOutElements actionsWithOutElements;
    final String BASE_URL = "http://prestashop.qatestlab.com.ua/en/";
    String expectedURL;


    public ParentPage(WebDriver webDriver, String partURL) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        actionsWithOutElements = new ActionWithOutElements(webDriver);
        expectedURL = BASE_URL+partURL;
    }

    public void checkIfPageOpen () {
        try {
            logger.info(expectedURL);
            logger.info(webDriver.getCurrentUrl());
            Assert.assertEquals("URL is not expected", Pattern.matches(expectedURL,webDriver.getCurrentUrl()), true);
        } catch (Exception e){
            logger.error ("Can't get url"+e);
            Assert.fail ("Can't get url");
        }
    }


}
