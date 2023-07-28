package autotests.tests;

import aquality.selenium.core.utilities.ISettingsFile;
import autotests.BaseTest;
import autotests.models.CurrentWeather;
import autotests.utilities.TestDataManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static autotests.utilities.TestDataManager.*;

public class WeatherStackApiTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger();

    @Test(dataProvider = "citiesList")
    public void currentWeatherInCityTest(ISettingsFile validateFilePath, String city) {
        TestDataManager data = new TestDataManager();
        CurrentWeather currentWeather = requestWeather(city).body().as(CurrentWeather.class);
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(currentWeather.getCurrent().getObservation_time(),
                data.getTestData(validateFilePath, "/observation_time"),
                "Actual observation time does not equal to expected result");

        softAssert.assertEquals(currentWeather.getCurrent().getTemperature(),
                Integer.parseInt(data.getTestData(validateFilePath, "/temperature")),
                "Actual temperature does not equal to expected result");

        softAssert.assertEquals(currentWeather.getCurrent().getWeather_code(),
                Integer.parseInt(data.getTestData(validateFilePath, "/weather_code")),
                "Actual weather code does not equal to expected result");

        softAssert.assertTrue((!currentWeather.getCurrent().getWeather_icons().isEmpty()),
                "Actual weather icons do not equal to expected result");

        softAssert.assertTrue(currentWeather.getCurrent().getWeather_descriptions().contains("Sunny"),
                "Actual weather descriptions does not equal to expected result");

        softAssert.assertEquals(currentWeather.getCurrent().getWind_speed(),
                Integer.parseInt(data.getTestData(validateFilePath, "/wind_speed")),
                "Actual wind speed does not equal to expected result");

        softAssert.assertEquals(currentWeather.getCurrent().getWind_degree(),
                Integer.parseInt(data.getTestData(validateFilePath, "/wind_degree")),
                "Actual wind degree does not equal to expected result");

        softAssert.assertEquals(currentWeather.getCurrent().getWind_dir(),
                data.getTestData(validateFilePath, "/wind_dir"),
                "Actual wind direction does not equal to expected result");

        softAssert.assertEquals(currentWeather.getCurrent().getPressure(),
                Integer.parseInt(data.getTestData(validateFilePath, "/pressure")),
                "Actual pressure does not equal to expected result");

        softAssert.assertEquals(currentWeather.getCurrent().getPrecip(),
                Integer.parseInt(data.getTestData(validateFilePath, "/precip")),
                "Actual precip does not equal to expected result");

        softAssert.assertEquals(currentWeather.getCurrent().getHumidity(),
                Integer.parseInt(data.getTestData(validateFilePath, "/humidity")),
                "Actual humidity does not equal to expected result");

        softAssert.assertEquals(currentWeather.getCurrent().getCloudcover(),
                Integer.parseInt(data.getTestData(validateFilePath, "/cloudcover")),
                "Actual cloudcover does not equal to expected result");

        softAssert.assertEquals(currentWeather.getCurrent().getFeelslike(),
                Integer.parseInt(data.getTestData(validateFilePath, "/feelslike")),
                "Actual feelslike does not equal to expected result");

        softAssert.assertEquals(currentWeather.getCurrent().getVisibility(),
                Integer.parseInt(data.getTestData(validateFilePath, "/visibility")),
                "Actual visibility does not equal to expected result");

        softAssert.assertEquals(currentWeather.getRequest().getType(),
                data.getTestData(validateFilePath, "/type"),
                "Actual type does not equal to expected result");

        softAssert.assertEquals(currentWeather.getRequest().getQuery(),
                data.getTestData(validateFilePath, "/query"),
                "Actual query does not equal to expected result");

        softAssert.assertEquals(currentWeather.getRequest().getLanguage(),
                data.getTestData(validateFilePath, "/language"),
                "Actual language does not equal to expected result");

        softAssert.assertEquals(currentWeather.getRequest().getUnit(),
                data.getTestData(validateFilePath, "/unit"),
                "Actual unit does not equal to expected result");

        softAssert.assertEquals(currentWeather.getLocation().getName(),
                data.getTestData(validateFilePath, "/name"),
                "Actual name does not equal to expected result");

        softAssert.assertEquals(currentWeather.getLocation().getCountry(),
                data.getTestData(validateFilePath, "/country"),
                "Actual country does not equal to expected result");

        softAssert.assertEquals(currentWeather.getLocation().getRegion(),
                data.getTestData(validateFilePath, "/region"),
                "Actual region does not equal to expected result");

        softAssert.assertEquals(currentWeather.getLocation().getLat(),
                data.getTestData(validateFilePath, "/lat"),
                "Actual lat does not equal to expected result");

        softAssert.assertEquals(currentWeather.getLocation().getTimezone_id(),
                data.getTestData(validateFilePath, "/timezone_id"),
                "Actual timezone id does not equal to expected result");

        softAssert.assertEquals(currentWeather.getLocation().getLocaltime(),
                data.getTestData(validateFilePath, "/localtime"),
                "Actual localtime does not equal to expected result");

        softAssert.assertEquals(currentWeather.getLocation().getLocaltime_epoch(),
                Integer.parseInt(data.getTestData(validateFilePath, "/localtime_epoch")),
                "Actual localtime epoch does not equal to expected result");

        softAssert.assertEquals(currentWeather.getLocation().getUtc_offset(),
                data.getTestData(validateFilePath, "/utc_offset"),
                "Actual utc offset does not equal to expected result");
        try {
            softAssert.assertAll();
        } catch (AssertionError e) {
            LOGGER.error("Test failed. Assertion error occurred: {}", e.getMessage());
            throw e;
        }
    }

    @DataProvider(name = "citiesList", parallel = true)
    public Object[][] CitiesProvider() {
        return new Object[][]{
                {NEW_YORK_WEATHER_VALIDATE_DATA, "New York, United States of America"},
                {MINSK_WEATHER_VALIDATE_DATA, "Shanghai, China"},
                {MOSCOW_WEATHER_VALIDATE_DATA, "Moscow, Russia"},
                {TOMSK_WEATHER_VALIDATE_DATA, "Tomsk, Russia"}
        };
    }
}