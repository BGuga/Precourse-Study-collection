package vendingmachine.domain;

public class ProductAmount {

    public static final String MIN_AMOUNT_ERROR_MESSAGE = "[ERROR] 물건의 수량은 %d이상 이여야 합니다.";
    public static final int MIN_AMOUNT = 0;
    private final int amount;

    public ProductAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount < MIN_AMOUNT) {
            throw new IllegalArgumentException(String.format(MIN_AMOUNT_ERROR_MESSAGE, MIN_AMOUNT));
        }
    }
}
