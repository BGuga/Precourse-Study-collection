package vendingmachine.domain;

import java.util.*;
import java.util.stream.Collectors;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    // 추가 기능 구현


    public int getAmount() {
        return amount;
    }

    public static Map<Coin, Integer> LeastCoinOf(Money money) {
        Map<Coin, Integer> coinPocket = new HashMap<>();
        makeMoneyToLeastCoin(coinPocket, money.getMoney());
        return coinPocket;
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
