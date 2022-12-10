package vendingmachine.domain;

import java.util.Map;

public class VendingMachine {
    private CoinMachine coinMachine;
    private ProductMachine productMachine;
    private Money insertedMoney;
    private boolean machinePower;

    public VendingMachine() {
        this.coinMachine = new CoinMachine();
        this.productMachine = new ProductMachine();
        this.insertedMoney = new Money(0);
        this.machinePower = true;
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
        return productMachine.canBuyAnything(insertedMoney) && machinePower;
    }

    public Map<Coin, Integer> getChanges() {
        return coinMachine.getChanges(insertedMoney);
    }

    public Map<Coin, Integer> getEnrolledCoins() {
        return coinMachine.getAllCoins();
    }

    public void buy(String productName) {
        Product product = productMachine.getProductOf(productName);
        enoughInsertedMoney(product);
        try {
            productMachine.deleteOne(product);
            spendMoney(product.getProductPrice().getPrice());
        } catch (IllegalArgumentException e) {
            machineOff();
        }
    }

    public Money getInsertedMoney() {
        return insertedMoney;
    }

    private void enoughInsertedMoney(Product product) {
        if (insertedMoney.getMoney() < product.getProductPrice().getPrice()) {
            throw new IllegalArgumentException("[ERROR] 물건을 구입하기 위한 금액이 부족합니다.");
        }
    }

    private void machineOff() {
        this.machinePower = false;
    }

    private void spendMoney(int money) {
        this.insertedMoney.sub(money);
    }
}
