package racingcar.domain;

public class CarMoveValue {
    private final static int MIN_CAR_MOVE_INPUT = 0;
    public static final int MAX_CAR_MOVE_INPUT = 9;
    public static final String INVALID_MOVE_INPUT_MESSAGE = "[ERROR] 유효하지 않은 이동값의 입력입니다.";

    private final int value;

    public CarMoveValue(int value) {
        validateCheck(value);
        this.value = value;
    }

    public boolean isBigger(CarMoveValue anotherValue) {
        return this.value > anotherValue.value;
    }

    private void validateCheck(int value) {
        if (value < MIN_CAR_MOVE_INPUT || value > MAX_CAR_MOVE_INPUT) {
            throw new IllegalArgumentException(INVALID_MOVE_INPUT_MESSAGE);
        }
    }
}
