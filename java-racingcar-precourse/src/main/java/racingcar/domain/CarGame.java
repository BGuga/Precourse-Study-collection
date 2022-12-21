package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.dto.MultiPosition;
import racingcar.dto.Position;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarGame {
    private final List<Car> enrolledCars;

    public CarGame(List<Car> cars) {
        this.enrolledCars = cars;
    }

    public List<MultiPosition> moveCarsNTime(int time) {
        List<MultiPosition> multiPositions = new ArrayList<>();
        for (int i = 0; i < time; i++) {
            multiPositions.add(moveCars());
        }
        return multiPositions;
    }

    public List<Car> getWinningCars() {
        int winningPosition = getWinningCarPosition();
        return enrolledCars.stream()
                .filter(car -> car.getPosition().getPositionValue() == winningPosition)
                .collect(Collectors.toList());
    }

    private MultiPosition moveCars() {
        List<Position> positions = new ArrayList<>();
        for (Car car : enrolledCars) {
            car.move(makeRandomCarMoveValue());
            positions.add(car.getPosition());
        }
        return new MultiPosition(positions);
    }

    private CarMoveValue makeRandomCarMoveValue() {
        int randomIntValue = Randoms.pickNumberInRange(CarMoveValue.MIN_CAR_MOVE_INPUT, CarMoveValue.MAX_CAR_MOVE_INPUT);
        return new CarMoveValue(randomIntValue);
    }

    private int getWinningCarPosition() {
        return enrolledCars.stream()
                .map(car -> car.getPosition().getPositionValue())
                .max(Integer::compareTo)
                .get();
    }
}
