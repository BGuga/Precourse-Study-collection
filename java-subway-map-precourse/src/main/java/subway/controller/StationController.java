package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.StationInputView;
import subway.view.StationOutputView;

public class StationController {
    StationInputView inputView = new StationInputView();
    StationOutputView outputView = new StationOutputView();

    public void process() {
        processByCommand(inputView.getCommandByConsole());
    }

    private void processByCommand(StationCommand command) {
        if (command == StationCommand.ENROLL) {
            enrollStation();
        }
        if (command == StationCommand.DELETE) {
            deleteStation();
        }
        if (command == StationCommand.SEARCH) {
            searchStation();
        }
    }

    private void enrollStation() {
        try {
            StationRepository.addStation(getStationByConsole());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            enrollStation();
        }
    }

    private void deleteStation() {
        try {
            StationRepository.deleteStation(inputView.getDeleteStationNameByConsole());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            deleteStation();
        }
    }

    private void searchStation(){
        outputView.printStations(StationRepository.stations());
    }

    private Station getStationByConsole() {
        try {
            return new Station(inputView.getStationNameByConsole());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getStationByConsole();
        }
    }



}
