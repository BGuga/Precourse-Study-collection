package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    static {
        Line secondLine = new Line("2호선");
        secondLine.addStation(0, StationRepository.getStation("교대역"));
        secondLine.addStation(1, StationRepository.getStation("강남역"));
        secondLine.addStation(2, StationRepository.getStation("역삼역"));
        addLine(secondLine);

        Line thirdLine = new Line("3호선");
        thirdLine.addStation(0, StationRepository.getStation("교대역"));
        thirdLine.addStation(1, StationRepository.getStation("남부터미널역"));
        thirdLine.addStation(2, StationRepository.getStation("양재역"));
        thirdLine.addStation(3, StationRepository.getStation("매봉역"));
        addLine(thirdLine);

        Line newBundang = new Line("신분당선");
        newBundang.addStation(0, StationRepository.getStation("강남역"));
        newBundang.addStation(1, StationRepository.getStation("양재역"));
        newBundang.addStation(2, StationRepository.getStation("양재시민의숲역"));
        addLine(newBundang);
    }

    private static final List<Line> lines = new ArrayList<>();
    public static final String ALREADY_EXITING_STATION_ERROR_MESSAGE = "[ERROR] 이미 등록된 역입니다.";

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lineDuplicationCheck(line);
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    private static void lineDuplicationCheck(Line line) {
        if (isExitingLine(line)) {
            throw new IllegalArgumentException(ALREADY_EXITING_STATION_ERROR_MESSAGE);
        }
    }

    private static boolean isExitingLine(Line line) {
        return lines().stream().anyMatch(li -> Objects.equals(li.getName(), line.getName()));
    }
}
