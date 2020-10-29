package ui.pages.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    private static String URL = "/login";

    @FindBy(how = How.ID, using = "loginusername")
    private WebElement emailField;

    @FindBy(how = How.ID, using = "loginpassword")
    private WebElement passwordField;

    @FindBy(how = How.ID, using = "loginsubmit")
    private WebElement loginButton;

    @FindBy(how = How.ID, using = "error")
    private WebElement invalidLoginError;

    public LoginPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void gotoPage() {
        gotoPage(URL);
    }

    public void enterEmail(String email) {
        typeText(emailField, email);
    }

    public void enterPassword(String password) {
        typeText(passwordField, password);
    }

    public void pressLoginButton() {
        click(loginButton);
    }

    public String getInvalidLoginErrorMessage() {
        return getText(invalidLoginError);
    }

    public void login (String email, String password) {
        gotoPage();
        enterEmail(email);
        enterPassword(password);
        pressLoginButton();
    }
}


