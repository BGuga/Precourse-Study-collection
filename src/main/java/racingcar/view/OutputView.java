package racingcar.view;

import racingcar.domain.Car;
import racingcar.dto.MultiPosition;
import racingcar.dto.Position;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    public void printResult(List<MultiPosition> multiPositions) {
        System.out.println("실행 결과\n");
        for (MultiPosition multiPosition : multiPositions) {
            printCarPositions(multiPosition);
        }
    }

    public void printWinners(List<Car> winners) {
        StringBuilder winnerMessage = new StringBuilder();
        winnerMessage.append("최종 우승자 : ");
        winnerMessage.append(makeWinnerList(winners));
        System.out.println(winnerMessage);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    private void printCarPositions(MultiPosition multiPosition) {
        for (Position position : multiPosition.getPositions()) {
            printPosition(position);
        }
        System.out.println();
    }

    private void printPosition(Position position) {
        String outputPosition = "";
        outputPosition += position.getName().getName() + " : " + makeStepByPosition(position.getPositionValue());
        System.out.println(outputPosition);
    }

    private String makeStepByPosition(int position) {
        StringBuilder result = new StringBuilder();
        String step = "-";
        for (int i = 0; i < position; i++) {
            result.append(step);
        }
        return result.toString();
    }

    private String makeWinnerList(List<Car> cars) {
        StringJoiner stringMaker = new StringJoiner(", ");
        for (Car car : cars) {
            stringMaker.add(car.getName().getName());
        }
        return stringMaker.toString();
    }
}
