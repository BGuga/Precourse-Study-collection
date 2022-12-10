package vendingmachine.domain;

import java.util.*;
import java.util.stream.Collectors;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    public static final String INVALID_MONEY_TO_COIN_ERROR_MESSAGE = "[ERROR] 동전으로 바뀔 수 없는 돈의 입력 입니다.";

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    // 추가 기능 구현


    public int getAmount() {
        return amount;
    }

    public static Map<Coin, Integer> LeastCoinOf(int money) {
        checkValidMoney(money);
        Map<Coin, Integer> coinPocket = new HashMap<>();
        makeMoneyToLeastCoin(coinPocket, money);
        return coinPocket;
    }

    private static void checkValidMoney(int money) {
        if (money < 0 || money % 10 != 0) {
            throw new IllegalArgumentException(INVALID_MONEY_TO_COIN_ERROR_MESSAGE);
        }
    }

    private static void makeMoneyToLeastCoin(Map<Coin, Integer> coinPocket, int money) {
        List<Coin> orderedCoinList = getReverseOrderCoinByPrice();
        for (Coin coin : orderedCoinList) {
            int coins = money / coin.amount;
            money -= coins * coin.amount;
            insertCoin(coinPocket, coin, coins);
        }
    }

    private static List<Coin> getReverseOrderCoinByPrice() {
        return Arrays.stream(Coin.values())
                .sorted(Comparator.comparing(Coin::getAmount).reversed())
                .collect(Collectors.toList());
    }

    private static void insertCoin(Map<Coin, Integer> coinPocket, Coin coin, int coinNumbers) {
        if (coinNumbers == 0) {
            return;
        }
        coinPocket.put(coin, coinNumbers);
    }
}
