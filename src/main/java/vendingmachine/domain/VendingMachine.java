package vendingmachine.domain;

public class VendingMachine {
    private CoinMachine coinMachine;
    private ProductMachine productMachine;
    private Money insertedMoney;

    public VendingMachine() {
        this.coinMachine = new CoinMachine();
        this.productMachine = new ProductMachine();
    }

    public void addProductBundle(ProductBundle productBundle) {
        productMachine.addProducts(productBundle);
    }

    public void insertMoney(Money money) {
        this.insertedMoney.add(money);
    }
}
