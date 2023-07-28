package autotests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public abstract class BaseTest {
    public Response requestWeather(String city) {
        return given()
                .queryParam("access_key", "491f5bb6ab63123473aaf0078e0f7e92")
                .queryParam("query", city)
                .when()
                .get("http://api.weatherstack.com/current");
    }
}


