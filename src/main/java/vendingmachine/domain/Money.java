package vendingmachine.domain;

public class Money {
    public static final String INVALID_MONEY_ERROR_MESSAGE = "[ERROR] 돈은 10으로 나누어 떨어져야 합니다.";

    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (money % 10 != 0) {
            throw new IllegalArgumentException(INVALID_MONEY_ERROR_MESSAGE);
        }
    }
}
