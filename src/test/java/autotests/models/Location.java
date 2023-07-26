package autotests.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Location {

    private String name;
    private String country;
    private String region;
    private String lat;
    private String lon;
    private String timezone_id;
    private String localtime;
    private int localtime_epoch;
    private String utc_offset;
}