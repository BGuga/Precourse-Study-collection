package racingcar.domain;

import racingcar.dto.Position;

public class Car {
    private final static CarMoveValue standardForMovingValue = new CarMoveValue(3);
    private final CarName name;
    private int position = 0;

    public Car(String name) {
        this.name = new CarName(name);
    }

    public CarName getName() {
        return name;
    }

    public void move(CarMoveValue num) {
        if (num.isBigger(standardForMovingValue))
            this.position++;
    }

    public Position getPosition() {
        return new Position(this.name, this.position);
    }


    // 추가 기능 구현
}
