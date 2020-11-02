package api;

import api.pojo.Item;
import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ItemAPI extends HTTPClient {
    private Logger LOGGER = LoggerFactory.getLogger(ItemAPI.class);
    private static final String ITEM_RESOURCE_PATH = "/item";
    private static final String ITEMS_RESOURCE_PATH = "/items";

    public Response getItem(String id) {
        Response response = get(ITEM_RESOURCE_PATH, id);
        LOGGER.info("The response is:");
        response.prettyPrint();
        return response;
    }


    public Response getAllItems() {
        Response response = get(ITEMS_RESOURCE_PATH);
        LOGGER.info("The response is:");
        response.prettyPrint();
        return response;
    }

    public Response deleteItem(String id) {
        Response response = delete(ITEM_RESOURCE_PATH, id);
        LOGGER.info("The response is:");
        response.prettyPrint();
        return response;
    }

    public Response createItem(Item item) {
        Response response = post(ITEM_RESOURCE_PATH, GSON.toJson(item));
        LOGGER.info("The response is:");
        response.prettyPrint();
        return response;
    }

    public Response updateItem(String id, Item item) {
        Response response = put(ITEM_RESOURCE_PATH, id, GSON.toJson(item));
        LOGGER.info("The response is:");
        response.prettyPrint();
        return response;
    }

    public void deleteAllItems() {
        //Get all items
        Response getAllItemsResponse = getAllItems();
        //Get all ids from the response
        List<String> ids = JsonPath.read(getAllItemsResponse.getBody().asString(), "$..id");
        LOGGER.info("Element found is:" + ids.toString());

        //Delete all items one by one using deleteItem
        ids.forEach(id -> deleteItem(id));
    }
}
