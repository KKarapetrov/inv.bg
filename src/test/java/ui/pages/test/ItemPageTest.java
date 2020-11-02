package ui.pages.test;

import api.ItemAPI;
import api.pojo.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.pages.pages.ItemPage;
import ui.pages.pages.LoginPage;

public class ItemPageTest extends BaseTest {

    @Test
    @DisplayName("Can navigate to Items page")
    public void canNavigateToItemsPage() {
        //Page object instances
        LoginPage loginPage = new LoginPage(driver);
        ItemPage itemPage = new ItemPage(driver);
        //Login in the system
        loginPage.login("karamfilovs@gmail.com", "123456");
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
        ItemPage itemPage = new ItemPage(driver);
        ItemAPI itemAPI = new ItemAPI();
        //Login in the system
        loginPage.login("karamfilovs@gmail.com", "123456");
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
        ItemPage itemPage = new ItemPage(driver);
        ItemAPI itemAPI = new ItemAPI();
        //Login in the system
        loginPage.login("karamfilovs@gmail.com", "123456");
        itemPage.gotoPage();
        Item item = Item
                .builder()
                .price_for_quantity(5)
                .quantity_unit("кг.")
                .build();

        for(int i=0; i<10; i++){
            item.setName("Bulk Item" + i);
            itemAPI.createItem(item);
        }

        //Search for full and partial match

        //Clean everything
        itemAPI.deleteAllItems();

    }


}