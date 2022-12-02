package subway.view;

import subway.domain.Line;
import subway.domain.Station;

import java.util.List;

public class MainOutputView {
    public void printLineMap(List<Line> lines) {
        System.out.println("## 지하철 노선도");
        for (Line line : lines) {
            printLine(line);
        }
    }

    private void printLine(Line line) {
        System.out.println(line.getName());
        System.out.println("---");
        printStations(line.getStations());
    }

    private void printStations(List<Station> stations) {
        for (Station station : stations) {
            System.out.println("[INFO] " + station.getName());
        }
    }
}
