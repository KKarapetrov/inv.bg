package ui.pages.test;

import api.ItemAPI;
import api.pojo.Items;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.pages.pages.ItemsPage;
import ui.pages.pages.LoginPage;

public class ItemsPageTest extends BaseTest {

    @Test
    @DisplayName("Can navigate to Items page")
    public void canNavigateToItemsPage() {
        //Page object instances
        LoginPage loginPage = new LoginPage(driver);
        ItemsPage itemPage = new ItemsPage(driver);
        //Login in the system
        loginPage.login("krum.karapetrov@gmail.com", "admin123");
        //Navigation to Items page
        itemPage.gotoPage();
        //Check that the navigation was successful
        Assertions.assertEquals("Управление на артикули - QA Ground", itemPage.getPageTitle());
    }

    @Test
    @DisplayName("Can create new item")
    public void canCreateNewItem() {
        //Page object instances
        LoginPage loginPage = new LoginPage(driver);
        ItemsPage itemPage = new ItemsPage(driver);
        ItemAPI itemAPI = new ItemAPI();
        //Login in the system
        loginPage.login("krum.karapetrov@gmail.com", "admin123");
        //Navigation to Items page
        itemPage.gotoPage();
        //Check that the navigation was successful
        Assertions.assertEquals("Управление на артикули - QA Ground", itemPage.getPageTitle());
        //Create new item via the UI
        itemPage.createItem("Item name 23424", 5, "кг.");
        Assertions.assertEquals("Артикулът е добавен успешно.", itemPage.getSuccessCreateMessage());
        //Delete newly created item via API
        itemAPI.deleteAllItems();
    }


    @Test
    public void canSearchForItems(){
        //Page object instances
        LoginPage loginPage = new LoginPage(driver);
        ItemsPage itemPage = new ItemsPage(driver);
        ItemAPI itemAPI = new ItemAPI();
        //Login in the system
        loginPage.login("krum.karapetrov@gmail.com", "admin123");
        itemPage.gotoPage();
        Items item = Items
                .builder()
                .price_for_quantity(5)
                .quantity_unit("кг.")
                .build();

        for(int i=0; i<10; i++){
            Items.setName("Bulk Item" + i);
            itemAPI.createItem(item);
        }

        //Search for full and partial match

        //Clean everything
        itemAPI.deleteAllItems();

    }
}
