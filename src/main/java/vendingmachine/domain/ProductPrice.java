package vendingmachine.domain;

public class ProductPrice {

    public static final String MIN_PRICE_ERROR_MESSAGE_FORMAT = "[ERROR] 상품의 가격은 최소 %d원 입니다.";
    public static final String PRICE_MULTIPLE_VALUE_ERROR_MESSAGE_FORMAT = "[ERROR] 상품 금액은 %d원으로 나누어 떨어져야 합니다.";
    public static final int MIN_PRICE = 100;
    public static final int REQUIRED_MULTIPLE = 10;

    private final int price;

    public ProductPrice(int price) {
        validatePrice(price);
        this.price = price;
    }

    private void validatePrice(int price) {
        checkMinPrice(price);
        checkMultiple(price);
    }

    private void checkMinPrice(int price) {
        if (price < MIN_PRICE) {
            throw new IllegalArgumentException(String.format(MIN_PRICE_ERROR_MESSAGE_FORMAT, MIN_PRICE));
        }
    }

    private void checkMultiple(int price) {
        if (price % REQUIRED_MULTIPLE != 0) {
            throw new IllegalArgumentException(String.format(PRICE_MULTIPLE_VALUE_ERROR_MESSAGE_FORMAT, REQUIRED_MULTIPLE));
        }
    }
}
