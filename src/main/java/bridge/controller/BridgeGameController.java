package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.Command;
import bridge.domain.Direction;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void process() {
        outputView.printGameStartingMessage();
        BridgeGame bridgeGame = new BridgeGame(getRandomBridgeFromUserByBridge());
        while (!bridgeGame.isNeedToQuit()) {
            playGameUntilEnd(bridgeGame);
            askGameCommand(bridgeGame);
        }
        outputView.printResult(bridgeGame.getGameResult());
    }

    private Bridge getRandomBridgeFromUserByBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int bridgeLength = inputView.readBridgeSize();
        return new Bridge(bridgeMaker.makeBridge(bridgeLength));
    }

    private void playGameUntilEnd(BridgeGame bridgeGame) {
        while (!bridgeGame.isEndGame()) {
            Direction direction = inputView.readDirection();
            bridgeGame.move(direction);
            outputView.printMap(bridgeGame.getProgressUserState());
        }
    }

    private void askGameCommand(BridgeGame bridgeGame) {
        if (bridgeGame.isNeedToQuit()) {
            return;
        }
        bridgeGame.retry(inputView.readGameCommand());
    }
}
