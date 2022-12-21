package racingcar.domain;

public class CarName {
    private final static int MIN_CAR_NAME_LENGTH = 1;
    public static final int MAX_CAR_NAME_LENGTH = 5;
    public static final String INVALID_NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 유효하지 않은 자동차의 이름 입니다.";

    private final String name;

    public CarName(String name) {
        checkValidation(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void checkValidation(String name) {
        checkNameLength(name.length());
    }

    private void checkNameLength(int length) {
        if (length < MIN_CAR_NAME_LENGTH || length > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_ERROR_MESSAGE);
        }
    }
}
