package subway.domain;

import java.util.*;

public class StationRepository {
    static {
        addStation(new Station("교대역"));
        addStation(new Station("강남역"));
        addStation(new Station("역삼역"));
        addStation(new Station("남부터미널역"));
        addStation(new Station("양재역"));
        addStation(new Station("양재시민의숲역"));
        addStation(new Station("매봉역"));
    }

    public static final String ALREADY_EXITING_STATION_ERROR_MESSAGE = "[ERROR] 이미 등록된 역입니다.";
    public static final String NON_EXITING_STATION_ERROR_MESSAGE = "[ERROR] 존재하지 않는 역 이름 입니다.";
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stationDuplicationCheck(station);
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        Station targetStation = getStation(name);
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static Station getStation(String name) {
        return stations().stream()
                .filter(station -> station.getName().equals(name))
                .findAny()
                .orElseThrow(()-> new IllegalArgumentException(NON_EXITING_STATION_ERROR_MESSAGE));
    }

    private static void stationDuplicationCheck(Station station) {
        if (isExistingStation(station)) {
            throw new IllegalArgumentException(ALREADY_EXITING_STATION_ERROR_MESSAGE);
        }
    }

    private static boolean isExistingStation(Station station) {
        return stations.stream().anyMatch(st -> Objects.equals(st.getName(), station.getName()));
    }
}
