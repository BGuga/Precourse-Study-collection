package subway.domain;

public class Station {
    public static final String STATION_NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 역의 이름은 2글자 이상으로 구성됩니다.";
    private String name;

    public Station(String name) {
        this.name = name;
        stationValidation(name);
    }

    public String getName() {
        return name;
    }

    private void stationValidation(String name) {
        final int minLineNameLength = 2;
        if (name.length() < minLineNameLength) {
            throw new IllegalArgumentException(STATION_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    // 추가 기능 구현
}
