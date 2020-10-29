package ui.pages.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {
    private Logger LOGGER = LoggerFactory.getLogger(BasePage.class);
    protected final static String BASE_URL = "https://krumkarapetroveood.inv.bg";
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void typeText(WebElement element, String text) {
        LOGGER.info("Typing text" + text);
        element.clear();
        element.sendKeys(text);
    }

    protected void click(WebElement element) {
        LOGGER.info("Clicking element");
        element.click();
    }

    protected void gotoPage(String page){
        LOGGER.info("Navigating to page:" + BASE_URL + page);
        driver.navigate().to(BASE_URL + page);
    }

    protected String getText(WebElement element){
        return element.getText().trim();
    }

    protected String getTitle(){
        return driver.getTitle();
    }
}
