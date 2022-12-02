package subway.controller;

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
            enrollStation()
        }
        if (command == StationCommand.DELETE) {
            deleteStation();
        }
        if (command == StationCommand.SEARCH) {
            serachStation();
        }
    }
}
