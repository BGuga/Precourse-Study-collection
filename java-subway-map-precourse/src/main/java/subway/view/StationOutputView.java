package subway.view;

import subway.domain.Station;

import java.util.List;

public class StationOutputView {

    public void printErrorMessage(String message) {
        System.out.println(message);
        System.out.println();
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
