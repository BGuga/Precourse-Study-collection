package racingcar;

public class Car {
    private final static int MIN_CAR_NAME_LENGTH = 1;
    private final static int MAX_CAR_NAME_LENGTH = 5;
    private final static String INVALID_NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 유효하지 않은 자동차의 이름 길이입니다.";
    private final String name;
    private int position = 0;

    public Car(String name) {
        nameValidation(name);
        this.name = name;
    }

    private void nameValidation(String name) {
        checkNameLength(name.length());
    }

    private void checkNameLength(int length) {
        if (length < MIN_CAR_NAME_LENGTH || length > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    // 추가 기능 구현
}
