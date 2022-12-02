package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.LineInputView;
import subway.view.LineOutputView;
import subway.view.StationInputView;
import subway.view.StationOutputView;

public class LineController {

    LineInputView inputView = new LineInputView();
    LineOutputView outputView = new LineOutputView();

    public void process() {
        processByCommand(inputView.getCommandByConsole());
    }

    private void processByCommand(StationCommand command) {
        if (command == StationCommand.ENROLL) {
            enrollLine();
        }
        if (command == StationCommand.DELETE) {
            deleteLine();
        }
        if (command == StationCommand.SEARCH) {
            searchLine();
        }
    }

    private void enrollLine() {
        try {
            StationRepository.addStation(getStationByConsole());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            enrollStation();
        }
    }

    private void deleteLine() {
        try {
            StationRepository.deleteStation(inputView.getDeleteStationNameByConsole());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            deleteStation();
        }
    }

    private void searchLine(){
        outputView.printStations(StationRepository.stations());
    }

    private Station getLineByConsole() {
        try {
            return new Station(inputView.getStationNameByConsole());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getStationByConsole();
        }
    }
}
