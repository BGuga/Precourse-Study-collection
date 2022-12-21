package racingcar.dto;

import racingcar.domain.CarName;

public class Position {
    private final CarName name;
    private final int positionValue;

    public Position(CarName name, int position){
        this.name = name;
        this.positionValue = position;
    }

    public CarName getName() {
        return name;
    }

    public int getPositionValue() {
        return positionValue;
    }
}
