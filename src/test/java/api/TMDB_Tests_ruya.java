package api;

import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Listeners({AllureTestNg.class})
@Epic("The Movie Database API")
@Feature("The Movie Database CRUD Operations")
public class TMDB_Tests_ruya extends BaseTest {

    private int account_id;

    @Test(priority = 3, description = "Get Account Details")
    @Story("Get Account")
    @Description("Get Account Details")
    @Severity(SeverityLevel.CRITICAL)
    public void getAccount(){

        Response response =
        given()
                .spec(request)

                .when()
                .get("/account")

                .then()
                .statusCode(200)
                .extract().response();

        account_id = response.path("id");
        response.body().prettyPrint();
    }

    @Test(priority = 4, description = "Add Movie to Favorites")
    @Story("Add Movie")
    @Description("Add Movie to Favorites")
    @Severity(SeverityLevel.NORMAL)
    public void addMovieToFavorites(){

        String createBody = """
                {
                    "media_type":"movie",
                    "media_id":550,
                    "favorite":true
                }
                """;

        Response response =
                given()
                        .spec(request)
                        .body(createBody)

                        .when()
                        .post("/account/{{account_id}}/favorite", account_id)
                        .then()
                        .statusCode(201)
                        .extract().response();
    }
}