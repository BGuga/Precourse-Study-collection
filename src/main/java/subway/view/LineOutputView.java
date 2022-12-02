package subway.view;

import subway.domain.Station;

import java.util.List;

public class LineOutputView {

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printStations(List<Station> stations) {
        for (Station station : stations) {
            System.out.println(makeStationOutputMessage(station));
        }
    }

    private String makeStationOutputMessage(Station station){
        return "[INFO] "+station.getName();
    }
}
