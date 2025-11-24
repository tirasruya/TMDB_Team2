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

    @Test(priority = 5, description = "Add Movie to Watchlist")
    @Severity(SeverityLevel.NORMAL)
    public void addMovieToWatchlist(){

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
                        .post("/account/{{account_id}}/watchlist", account_id)
                        .then()
                        .statusCode(201)
                        .extract().response();
    }

    @Test(priority = 6, description = "Get Favorite Movies")
    @Severity(SeverityLevel.MINOR)
    public void getFavoriteMovies(){

        Response response =
                given()
                        .spec(request)

                        .when()
                        .get("/account/{{account_id}}/favorite/movies", account_id)

                        .then()
                        .statusCode(200)
                        .extract().response();

        response.body().prettyPrint();
    }

    @Test(priority = 7, description = "Get Rated Movies")
    @Severity(SeverityLevel.MINOR)
    public void getRatedMovies(){

        Response response =
                given()
                        .spec(request)

                        .when()
                        .get("/account/{{account_id}}/rated/movies", account_id)

                        .then()
                        .statusCode(200)
                        .extract().response();

        response.body().prettyPrint();
    }

    @Test(priority = 8, description = "Get Watchlist Movies")
    @Severity(SeverityLevel.MINOR)
    public void getWatchlistMovies(){

        Response response =
                given()
                        .spec(request)

                        .when()
                        .get("/account/{{account_id}}/watchlist/movies", account_id)

                        .then()
                        .statusCode(200)
                        .extract().response();

        response.body().prettyPrint();
    }

    @Test(priority = 9, description = "Get Movie Genres")
    @Severity(SeverityLevel.MINOR)
    public void getMovieGenres(){

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
    public void getNowPlayingMovies(){

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
    public void getPopularMovies(){

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
    public void getTopRatedMovies(){

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
}