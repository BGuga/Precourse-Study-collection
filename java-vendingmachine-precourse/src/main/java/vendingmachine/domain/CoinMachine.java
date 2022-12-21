package vendingmachine.domain;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CoinMachine {
    private Map<Coin, Integer> coins = new HashMap<>();

    public CoinMachine() {

    }

    public void insertMoney(Money money) {
        Map<Coin, Integer> coinIntegerMap = Coin.LeastCoinOf(money);
        for (Coin coin : coinIntegerMap.keySet()) {
            coins.computeIfPresent(coin, (key, value) -> value + coinIntegerMap.get(coin));
            coins.computeIfAbsent(coin, value -> coinIntegerMap.get(coin));
        }
    }

    public Map<Coin, Integer> getChanges(Money money) {
        int moneyValue = money.getMoney();
        Map<Coin, Integer> changes = new HashMap<>();
        for (Coin coin : getOrderedCoin()) {
            int coinCount = getCoinCount(moneyValue, coin);
            moneyValue -= coinCount * coin.getAmount();
            changes.put(coin, coinCount);
        }
        deleteCoins(changes);
        return changes;
    }

    public Map<Coin, Integer> getAllCoins() {
        return coins;
    }

    private List<Coin> getOrderedCoin() {
        return coins.keySet().stream()
                .sorted(Comparator.comparing(Coin::getAmount).reversed())
                .collect(Collectors.toList());
    }

    private int getCoinCount(int money, Coin coin) {
        int count = money / coin.getAmount();
        if (count > coins.get(coin)) {
            return coins.get(coin);
        }
        return count;
    }

    private void deleteCoins(Map<Coin, Integer> deletingCoins) {
        for (Coin coin : deletingCoins.keySet()) {
            coins.replace(coin, coins.get(coin) - deletingCoins.get(coin));
        }
    }
}
