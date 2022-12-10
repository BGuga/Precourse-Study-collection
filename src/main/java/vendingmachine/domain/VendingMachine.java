package vendingmachine.domain;

import java.util.Map;

public class VendingMachine {
    private CoinMachine coinMachine;
    private ProductMachine productMachine;
    private Money insertedMoney;

    public VendingMachine() {
        this.coinMachine = new CoinMachine();
        this.productMachine = new ProductMachine();
        this.insertedMoney = new Money(0);
    }

    public void addProductBundle(ProductBundle productBundle) {
        productMachine.addProducts(productBundle);
    }

    public void insertMoneyInCoinMachine(Money money) {
        coinMachine.insertMoney(money);
    }

    public void insertMoney(Money money) {
        this.insertedMoney.add(money);
    }

    public boolean canBuy() {
        return productMachine.canBuyAnything(insertedMoney);
    }

    public Map<Coin, Integer> getChanges() {
        return coinMachine.getChanges(insertedMoney);
    }
}
