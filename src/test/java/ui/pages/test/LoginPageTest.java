package ui.pages.test;

import org.junit.jupiter.api.*;
import ui.pages.pages.DashboardPage;
import ui.pages.pages.LoginPage;

public class LoginPageTest extends BaseTest {


    @org.junit.jupiter.api.Test
    @DisplayName("Can login with valid credentials")
    public void canLoginWithValidCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        loginPage.gotoPage();
        loginPage.enterEmail("krum.karapetrov@gmail.com");
        loginPage.enterPassword("admin123");
        loginPage.pressLoginButton();
        Assertions.assertEquals("krum.karapetrov@gmail.com", dashboardPage.getUserPanelText());
    }


    @org.junit.jupiter.api.Test
    @DisplayName("Cant login with invalid credentials")
    public void cantLoginWithInvalidCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.gotoPage();
        loginPage.enterEmail("krum.karapetrov@gmail.com");
        loginPage.enterPassword("admin123");
        loginPage.pressLoginButton();
        Assertions
                .assertEquals("Грешно потребителско име или парола. Моля, опитайте отново.", loginPage.getInvalidLoginErrorMessage());
    }

    @Test
    @DisplayName("Cant login with blank credentials")
    public void cantLoginWithBlankCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.gotoPage();
        loginPage.enterEmail("");
        loginPage.enterPassword("");
        loginPage.pressLoginButton();
        Assertions
                .assertEquals("Моля, попълнете вашия email", loginPage.getInvalidLoginErrorMessage());
    }

}


