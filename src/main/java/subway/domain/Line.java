package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    public static final String ALREADY_EXITING_STATION_ERROR_MESSAGE = "[ERROR] 이미 노선에 존재하는 역입니다";

    private String name;
    private List<Station> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStation(Station station, int index) {
        stationValidation(station);
    }

    private void stationValidation(Station station) {
        checkDuplications(station);
    }

    private void checkDuplications(Station station) {
        for (Station originStation : stations) {
            checkDuplication(originStation, station);
        }
    }

    private void checkDuplication(Station originStation, Station compareStation) {
        if (originStation.getName().equals(compareStation)) {
            throw new IllegalArgumentException(ALREADY_EXITING_STATION_ERROR_MESSAGE);
        }
    }

    // 추가 기능 구현
}
