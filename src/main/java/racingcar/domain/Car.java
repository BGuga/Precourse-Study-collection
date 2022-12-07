package racingcar.domain;

public class Car {
    private final static CarMoveValue standardForMovingValue = new CarMoveValue(4);
    private final CarName name;
    private int position = 0;

    public Car(String name) {
        this.name = new CarName(name);
    }

    public void move(CarMoveValue num) {
        if(num.isBigger(standardForMovingValue))
        this.position++;
    }




    // 추가 기능 구현
}
