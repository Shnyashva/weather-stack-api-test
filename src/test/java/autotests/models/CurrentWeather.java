package autotests.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CurrentWeather {

    private Request request;
    private Location location;
    private Current current;
}