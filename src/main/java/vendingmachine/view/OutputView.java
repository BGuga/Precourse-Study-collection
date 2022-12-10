package vendingmachine.view;

import vendingmachine.domain.Coin;

import java.util.Map;

public class OutputView {

    public void printExchange(Map<Coin, Integer> coins) {
        System.out.println("자판기가 보유한 동전");
        printAllCoins(coins);
    }

    private void printAllCoins(Map<Coin, Integer> coins) {
        for (Coin coin : Coin.values()) {
            printCoin(coin, coins.getOrDefault(coin, 0));
        }
    }

    private void printCoin(Coin coin, Integer coinCount) {
        System.out.println(String.format("%d원 - %d개", coin.getAmount(), coinCount));
    }
}
