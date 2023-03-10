package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    {
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

    private static final List<Line> linesdata = new ArrayList<>();
    public static final String ALREADY_EXITING_STATION_ERROR_MESSAGE = "[ERROR] 이미 등록된 역입니다.";
    public static final String NON_EXITING_STATION_ERROR_MESSAGE = "[ERROR] 존재 하지 않는 역의 입력 입니다.";

    public static List<Line> lines() {
        return Collections.unmodifiableList(linesdata);
    }

    public static void addLine(Line line) {
        lineDuplicationCheck(line);
        linesdata.add(line);
    }

    public static Line getLine(String name) {
        return lines().stream()
                .filter(line -> line.getName().equals(name))
                .findAny()
                .orElseThrow(()-> new IllegalArgumentException(NON_EXITING_STATION_ERROR_MESSAGE));
    }

    public static void deleteLineByName(String name) {
        boolean deletedLine = linesdata.removeIf(line -> Objects.equals(line.getName(), name));
        if (deletedLine == false) {
            throw new IllegalArgumentException(NON_EXITING_STATION_ERROR_MESSAGE);
        }
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
