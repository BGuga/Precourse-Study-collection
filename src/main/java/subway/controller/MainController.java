package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.view.MainInputView;
import subway.view.MainOutputView;

import java.util.List;

public class MainController {
    MainInputView inputView = new MainInputView();
    MainOutputView outputView = new MainOutputView();

    public void process() {
        MainCommand mainCommand;
        settingForRepository();
        do {
            mainCommand = inputView.getCommandByConsole();
            processByCommand(mainCommand);
        } while (!(mainCommand == MainCommand.QUIT));
    }

    private void settingForRepository(){
        StationRepository stationRepository = new StationRepository();
        LineRepository lineRepository = new LineRepository();
    }

    private void processByCommand(MainCommand mainCommand) {
        if (mainCommand == MainCommand.STATION_MANAGEMENT) {
            progressStationManagement();
        }
        if (mainCommand == MainCommand.LINE_MANAGEMENT) {
            progressLineManagement();
        }
        if (mainCommand == MainCommand.SECTION_MANAGEMENT) {
            progressSectionManagement();
        }
        if (mainCommand == MainCommand.PRINT_MAP) {
            progressPrintManagement();
        }
    }

    private void progressStationManagement() {
        StationController stationController = new StationController();
        stationController.process();
    }

    private void progressLineManagement() {
        LineController lineController = new LineController();
        lineController.process();
    }

    private void progressSectionManagement() {
        SectionController sectionController = new SectionController();
        sectionController.progress();
    }

    private void progressPrintManagement() {
        List<Line> lines = LineRepository.lines();
        outputView.printLineMap(lines);
    }

}
