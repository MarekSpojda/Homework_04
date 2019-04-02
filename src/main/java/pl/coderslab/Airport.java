package pl.coderslab;

public class Airport {
    private String name;
    private String code;
    private String timezone;

    public Airport(String name, String code, String timezone) {
        this.name = name;
        this.code = code;
        this.timezone = timezone;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getTimezone() {
        return timezone;
    }
}
