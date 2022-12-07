package racingcar.view;

import racingcar.domain.MultiPosition;
import racingcar.domain.Position;

import java.util.List;

public class OutputView {

    public void printResult(List<MultiPosition> multiPositions) {
        System.out.println("실행 결과\n");
        for(MultiPosition multiPosition : multiPositions){
            printCarPositions(multiPosition);
        }
    }

    private void printCarPositions(MultiPosition multiPosition) {
        for (Position position : multiPosition.getPositions()) {
            printPosition(position);
        }
        System.out.println();
    }

    private void printPosition(Position position) {
        String outputPosition = "";
        outputPosition += position.getName().getName() + " : " + makeStepByPosition(position.getPosition());
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
}
