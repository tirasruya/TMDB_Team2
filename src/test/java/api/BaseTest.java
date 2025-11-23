package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected RequestSpecification request;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://api.themoviedb.org/3";

        request = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzNDgyZGE4NzEyZjU4ZTFlYmQ0NmFkM2I3MmNlMGJhYSIsIm5iZiI6MTc2MzMyOTU2OC4zMDA5OTk5LCJzdWIiOiI2OTFhNDYyMDE0YzhmY2VmNjAwYjViMjUiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.8bACXDqvCgxLK4Guuo9zfq9rnZ0OuM2ln6OU2WNSRn0");
    }
}