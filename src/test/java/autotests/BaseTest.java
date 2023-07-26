package autotests;

import autotests.models.CurrentWeather;
import groovy.transform.ASTTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BaseTest {

    private static final String URL = "http://api.weatherstack.com/current";

    @Test
    public void test() {
        Response response = given()
                .when()
                .get(URL);
    }
}
