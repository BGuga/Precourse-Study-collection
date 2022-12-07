package racingcar.domain;

public class Position {
    private final CarName name;
    private final int position;

    public Position(CarName name, int position){
        this.name = name;
        this.position = position;
    }

    public CarName getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
