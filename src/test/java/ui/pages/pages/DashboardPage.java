package ui.pages.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage {
    private static String URL = "/";

    @FindBy(how = How.XPATH, using = "//div[@class='userpanel-header']")
    private WebElement userPanelHeader;


    public DashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getUserPanelText(){
        return getText(userPanelHeader);
    }

}
