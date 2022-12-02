package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    public static final String ALREADY_EXITING_STATION_ERROR_MESSAGE = "[ERROR] 이미 노선에 존재하는 역입니다";
    public static final String LINE_NAME_LENGTH_ERROR_MESSAGE = "[ERROR] LINE의 이름은 2글자 이상으로 구성됩니다.";
    public static final String NON_EXITING_STATION_MESSAGE = "[ERROR] 해당 노선에 존재하지 않는 역입니다.";

    private String name;
    private List<Station> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
        lineValidation(name);
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void addStation(int index, Station station) {
        stationValidation(station);
        stations.add(index, station);
    }

    public void deleteStation(Station station) {
        minStationValidation();
        boolean deleted = stations.removeIf((st) -> st.getName().equals(station.getName()));
        if (!deleted) {
            throw new IllegalArgumentException(NON_EXITING_STATION_MESSAGE);
        }
    }

    private void lineValidation(String name) {
        final int minLineNameLength = 2;
        if (name.length() < minLineNameLength) {
            throw new IllegalArgumentException(LINE_NAME_LENGTH_ERROR_MESSAGE);
        }
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
        if (originStation.getName().equals(compareStation.getName())) {
            throw new IllegalArgumentException(ALREADY_EXITING_STATION_ERROR_MESSAGE);
        }
    }

    private void minStationValidation() {
        if (stations.size() < 3) {
            throw new IllegalArgumentException("[ERROR] 노선은 최소 2개의 역을 가지고 있어야 합니다.");
        }
    }

    // 추가 기능 구현
}
