package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HTTPClient {
    //Logger
    private Logger LOGGER = LoggerFactory.getLogger(HTTPClient.class);
    //Credentials
    private static final String EMAIL = "krum.karapetrov@gmail.com";
    private static final String PASSWORD = "admin123";
    //Addresses for the requests
    private static final String BASE_URI = "https://krumkarapetroveood.inv.bg";
    private static final String BASE_PATH = "/RESTapi";

    //Gson instance
    protected Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    static {
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = BASE_PATH;
        RestAssured.authentication = RestAssured.preemptive().basic(EMAIL, PASSWORD);
    }

    protected Response get(String resourceURL, String id) {
        return RestAssured
                .given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .when()
                .get(resourceURL + "/" + id);
    }

    protected Response get(String resourceURL) {
        return RestAssured
                .given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .when()
                .get(resourceURL);
    }

    protected Response post(String resourceURL, String body) {
        return RestAssured
                .given()
                .body(body)
                .log()
                .all()
                .contentType(ContentType.JSON)
                .when()
                .post(resourceURL);
    }

    protected Response put(String resourceURL, String id,  String body) {
        return RestAssured
                .given()
                .body(body)
                .log()
                .all()
                .contentType(ContentType.JSON)
                .when()
                .put(resourceURL + "/" + id);
    }


    protected Response delete(String resourceURL, String id) {
        return RestAssured
                .given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .when()
                .delete(resourceURL + "/" +  id);
    }

}
