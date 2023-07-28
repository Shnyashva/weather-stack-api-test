package autotests.utilities;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import lombok.Getter;

import static autotests.constants.FileNames.*;
@Getter
public class TestDataManager {

    public static final ISettingsFile NEW_YORK_WEATHER_VALIDATE_DATA = new JsonSettingsFile(NEW_YORK_WEATHER_VALIDATE_DATA_PATH);
    public static final ISettingsFile MINSK_WEATHER_VALIDATE_DATA = new JsonSettingsFile(MINSK_WEATHER_VALIDATE_DATA_PATH);
    public static final ISettingsFile MOSCOW_WEATHER_VALIDATE_DATA = new JsonSettingsFile(MOSCOW_WEATHER_VALIDATE_DATA_PATH);
    public static final ISettingsFile TOMSK_WEATHER_VALIDATE_DATA = new JsonSettingsFile(TOMSK_WEATHER_VALIDATE_DATA_PATH);

    public String getTestData(ISettingsFile fileName, String path) {
        return fileName.getValue(path).toString();
    }
}