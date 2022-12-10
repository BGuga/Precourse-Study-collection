package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;

public class CoinMachine {
    private Map<Coin, Integer> coins = new HashMap<>();

    public CoinMachine() {

    }

    public void insertMoney(int money) {
        Map<Coin, Integer> coinIntegerMap = Coin.LeastCoinOf(money);
        for (Coin coin : coinIntegerMap.keySet()) {
            coins.computeIfPresent(coin, (key, value) -> value + coinIntegerMap.get(coin));
            coins.computeIfAbsent(coin, value -> coinIntegerMap.get(coin));
        }
    }
}
