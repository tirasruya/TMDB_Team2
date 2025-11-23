package api;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ProjectTests extends BaseTest {

    @Test(priority = 1, description = "Get Account Details")
    public void getAccount(){

        Response response =
        given()
                .spec(request)

                .when()
                .get("/account")

                .then()
                .statusCode(200)
                .extract().response();

        response.body().prettyPrint();
    }
}