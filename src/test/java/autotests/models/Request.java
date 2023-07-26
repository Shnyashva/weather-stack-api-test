package autotests.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Request {

    private String type;
    private String query;
    private String language;
    private String unit;
}