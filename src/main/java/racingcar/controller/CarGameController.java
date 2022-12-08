package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarGame;
import racingcar.domain.MultiPosition;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class CarGameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void process() {
        try {
            CarGame carGame = new CarGame(inputView.readCars());
            playGameNTime(carGame);
            printResult(carGame);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }


    private void playGameNTime(CarGame game) {
        List<MultiPosition> multiPositions = game.moveCarsNTime(inputView.readTrialNumbers());
        outputView.printResult(multiPositions);
    }

    private void printResult(CarGame game) {
        List<Car> winningCars = game.getWinningCars();
        outputView.printWinners(winningCars);
    }
}
