package ui.pages.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ItemPage extends BasePage {
    private final String URL = "/objects/manage";

    @FindBy(how = How.XPATH, using = "//div[@class='userpanel-header']")
    private WebElement userPanelHeader;

    @FindBy(how = How.XPATH, using = "//a[@class='newbtn selenium-add-item']")
    private WebElement newItemButton;

    @FindBy(how = How.NAME, using = "name")
    private WebElement nameField;

    @FindBy(how = How.NAME, using = "price")
    private WebElement priceField;

    @FindBy(how = How.NAME, using = "price_quantity_unit")
    private WebElement unitDropDown;

    @FindBy(how = How.NAME, using = "do_submit")
    private WebElement addItemButton;

    @FindBy(how = How.ID, using = "okmsg")
    private WebElement successCreateMessage;


    public ItemPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void gotoPage() {
        gotoPage(URL);
    }

    public String getPageTitle() {
        return getTitle();
    }

    public void clickNewItemButton(){
        click(newItemButton);
    }

    public void enterName(String name){
        typeText(nameField, name);
    }

    public void enterUnit(String unit){
        typeText(unitDropDown, unit);
    }

    public void enterPrice(int price){
        typeText(priceField, String.valueOf(price));
    }

    public void pressAddItemButton(){
        click(addItemButton);
    }




    public void createItem(String item_name, int price, String unit) {
        clickNewItemButton();
        enterName(item_name);
        enterPrice(price);
        //enterUnit(unit);
        pressAddItemButton();
    }

    public String getSuccessCreateMessage() {
        return getText(successCreateMessage);
    }
}
