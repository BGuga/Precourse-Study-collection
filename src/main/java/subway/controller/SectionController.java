package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.SectionInputView;
import subway.view.SectionOutputView;

public class SectionController {
    SectionInputView inputView = new SectionInputView();
    SectionOutputView outputView = new SectionOutputView();

    public void progress() {
        processByCommand(inputView.getCommandByConsole());
    }

    private void processByCommand(SectionCommand command) {
        if (command == SectionCommand.ENROLL) {
            addSection();
        }
        if (command == SectionCommand.DELETE) {
            deleteSection();
        }
    }

    private void addSection() {
        try {
            Line line = LineRepository.getLine(inputView.getLineNameByConsole());
            Station station = StationRepository.getStation(inputView.getStationByConsole());
            line.addStation(inputView.getStationIndex(), station);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            addSection();
        }
    }

    private void deleteSection() {
        try {
            Line line = LineRepository.getLine(inputView.getLineNameByConsole());
            Station station = StationRepository.getStation(inputView.getStationByConsole());
            line.deleteStation(station);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            deleteSection();
        }
    }
}
