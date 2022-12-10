package vendingmachine.domain;

public class Product {
    private final String productName;
    private final ProductPrice productPrice;

    public Product(String productName, ProductPrice productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public boolean isSame(Product otherProduct) {
        return this.productPrice.isSame(otherProduct.productPrice) && this.productName.equals(otherProduct.productName);
    }
}
