package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected RequestSpecification request;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://api.themoviedb.org/3/";

        request = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);
    }
}