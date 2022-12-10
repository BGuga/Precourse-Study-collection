package vendingmachine.view;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Money;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public void printExchange(Map<Coin, Integer> coins) {
        System.out.println("자판기가 보유한 동전");
        printAllCoins(coins);
    }

    public void printReceivedCoins(Map<Coin, Integer> coins) {
        System.out.println("잔돈");
        List<Coin> sortedCoinList = coins.keySet().stream().sorted(Comparator.comparing(Coin::getAmount)).collect(Collectors.toList());
        for (Coin coin : sortedCoinList) {
            printCoin(coin, coins.get(coin));
        }
    }

    public void printInsertedMoney(Money money){
        System.out.println(String.format("투입 금액: %d원", money.getMoney()));
    }

    public void printErrorMessage(String message){
        System.out.println(message);
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
