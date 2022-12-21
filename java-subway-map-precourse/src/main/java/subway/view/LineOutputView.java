package subway.view;

import subway.domain.Line;
import subway.domain.Station;

import java.util.List;

public class LineOutputView {

    public void printErrorMessage(String message) {
        System.out.println(message);
        System.out.println();
    }

    public void printLines(List<Line> lines) {
        for (Line line : lines) {
            System.out.println(makeStationOutputMessage(line));
        }
    }

    private String makeStationOutputMessage(Line line){
        return "[INFO] "+line.getName();
    }
}
