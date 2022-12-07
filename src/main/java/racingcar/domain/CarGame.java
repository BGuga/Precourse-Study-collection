package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Random;

public class CarGame {
    private final List<Car> enrolledCars;

    public CarGame(List<Car> cars) {
        this.enrolledCars = cars;
    }

    private void moveCars() {
        for (Car car : enrolledCars) {
            car.move(makeRandomCarMoveValue());
        }
    }

    private CarMoveValue makeRandomCarMoveValue() {
        int randomIntValue = Randoms.pickNumberInRange(CarMoveValue.MIN_CAR_MOVE_INPUT, CarMoveValue.MAX_CAR_MOVE_INPUT);
        return new CarMoveValue(randomIntValue);
    }
}
