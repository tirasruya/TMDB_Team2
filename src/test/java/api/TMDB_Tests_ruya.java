package api;

import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Listeners({AllureTestNg.class})
@Epic("The Movie Database API")
@Feature("The Movie Database CRUD Operations")
public class TMDB_Tests_ruya extends BaseTest {

    private int account_id;

    @Test(priority = 3, description = "Get Account Details")
    @Severity(SeverityLevel.CRITICAL)
    public void getAccount() {

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
    @Severity(SeverityLevel.NORMAL)
    public void addMovieToFavorites() {

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
                        .post("/account/{account_id}/favorite", account_id)
                        .then()
                        .statusCode(201)
                        .extract().response();
    }

    @Test(priority = 5, description = "Add Movie to Watchlist")
    @Severity(SeverityLevel.NORMAL)
    public void addMovieToWatchlist() {

        String createBody = """
                {
                    "media_type":"movie",
                    "media_id":11,
                    "watchlist":true
                }
                """;

        Response response =
                given()
                        .spec(request)
                        .body(createBody)

                        .when()
                        .post("/account/{account_id}/watchlist", account_id)
                        .then()
                        .statusCode(201)
                        .extract().response();
    }

    @Test(priority = 6, description = "Get Favorite Movies")
    @Severity(SeverityLevel.MINOR)
    public void getFavoriteMovies() {

        Response response =
                given()
                        .spec(request)

                        .when()
                        .get("/account/{account_id}/favorite/movies", account_id)

                        .then()
                        .statusCode(200)
                        .extract().response();

        response.body().prettyPrint();
    }

    @Test(priority = 7, description = "Get Rated Movies")
    @Severity(SeverityLevel.MINOR)
    public void getRatedMovies() {

        Response response =
                given()
                        .spec(request)

                        .when()
                        .get("/account/{account_id}/rated/movies", account_id)

                        .then()
                        .statusCode(200)
                        .extract().response();

        response.body().prettyPrint();
    }

    @Test(priority = 8, description = "Get Watchlist Movies")
    @Severity(SeverityLevel.MINOR)
    public void getWatchlistMovies() {

        Response response =
                given()
                        .spec(request)

                        .when()
                        .get("/account/{account_id}/watchlist/movies", account_id)

                        .then()
                        .statusCode(200)
                        .extract().response();

        response.body().prettyPrint();
    }

    @Test(priority = 9, description = "Get Movie Genres")
    @Severity(SeverityLevel.MINOR)
    public void getMovieGenres() {

        Response response =
                given()
                        .spec(request)

                        .when()
                        .get("/genre/movie/list")

                        .then()
                        .statusCode(200)
                        .extract().response();

        response.body().prettyPrint();
    }

    @Test(priority = 10, description = "Get Now Playing Movies")
    @Severity(SeverityLevel.MINOR)
    public void getNowPlayingMovies() {

        Response response =
                given()
                        .spec(request)

                        .when()
                        .get("/movie/now_playing")

                        .then()
                        .statusCode(200)
                        .extract().response();

        response.body().prettyPrint();
    }

    @Test(priority = 11, description = "Get Popular Movies")
    @Severity(SeverityLevel.MINOR)
    public void getPopularMovies() {

        Response response =
                given()
                        .spec(request)

                        .when()
                        .get("/movie/popular")

                        .then()
                        .statusCode(200)
                        .extract().response();

        response.body().prettyPrint();
    }

    @Test(priority = 12, description = "Get Top Rated Movies")
    @Severity(SeverityLevel.MINOR)
    public void getTopRatedMovies() {

        Response response =
                given()
                        .spec(request)

                        .when()
                        .get("/movie/top_rated")

                        .then()
                        .statusCode(200)
                        .extract().response();

        response.body().prettyPrint();
    }

    @Test(priority = 13, description = "Get Upcoming Movies")
    @Severity(SeverityLevel.MINOR)
    public void getUpcomingMovies() {

        Response response =
                given()
                        .spec(request)

                        .when()
                        .get("/movie/upcoming")

                        .then()
                        .statusCode(200)
                        .extract().response();

        response.body().prettyPrint();
    }

    @Test(priority = 14, description = "Search For Movies")
    @Severity(SeverityLevel.MINOR)
    public void searchForMovies() {

        Response response =
                given()
                        .spec(request)

                        .when()
                        .get("/search/movie?query=fight")

                        .then()
                        .statusCode(200)
                        .extract().response();

        response.body().prettyPrint();
    }

    @Test(priority = 15, description = "Get Movie Details")
    @Severity(SeverityLevel.MINOR)
    public void getMovieDetails() {

        Response response =
                given()
                        .spec(request)

                        .when()
                        .get("/movie/550")

                        .then()
                        .statusCode(200)
                        .extract().response();

        response.body().prettyPrint();
    }

    @Test(priority = 16, description = "Search For Keywords")
    @Severity(SeverityLevel.MINOR)
    public void searchForKeywords() {

        Response response =
                given()
                        .spec(request)

                        .when()
                        .get("/search/keyword?query=space")

                        .then()
                        .statusCode(200)
                        .extract().response();

        response.body().prettyPrint();
    }

    @Test(priority = 17, description = "Add Movie Rating")
    @Severity(SeverityLevel.NORMAL)
    public void addMovieRating() {

        String createBody = """
                {
                    "value": 8.5
                }
                """;

        Response response =
                given()
                        .spec(request)
                        .body(createBody)

                        .when()
                        .post("/movie/550/rating")
                        .then()
                        .statusCode(201)
                        .extract().response();
    }

    @Test(priority = 18, description = "Delete Movie Rating")
    @Severity(SeverityLevel.CRITICAL)
    public void deleteMovieRating() {

        given()
                .spec(request)

                .when()
                .delete("/movie/550/rating")

                .then()
                .statusCode(200);
    }

    @Test(priority = 19, description = "Unauthorized Access")
    @Severity(SeverityLevel.CRITICAL)
    public void unauthorizedAccess() {

        String createBody = """
                {
                  "media_id": 18
                }
                """;

        Response response =
                given()
                        .spec(request)
                        .body(createBody)

                        .when()
                        .post("/list/1581493/add_item?session_id=12345")
                        .then()
                        .statusCode(401)
                        .body("status_message", equalTo("Authentication failed: You do not have permissions to access the service."))
                        .extract().response();
    }
}