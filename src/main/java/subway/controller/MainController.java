package subway.controller;

import subway.view.MainInputView;
import subway.view.MainOutputView;

public class MainController {
    MainInputView inputView = new MainInputView();
    MainOutputView outputView = new MainOutputView();

    public void process() {
        MainCommand mainCommand;
        do {
            mainCommand = inputView.getCommandByConsole();
            processByCommand(mainCommand);
        } while (!(mainCommand == MainCommand.QUIT));
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

    }
}
