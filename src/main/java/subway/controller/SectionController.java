package subway.controller;

import subway.view.SectionInputView;

public class SectionController {
    SectionInputView inputView = new SectionInputView();

    public void progress() {
        processByCommand(inputView.getCommandByConsole());
    }
}
