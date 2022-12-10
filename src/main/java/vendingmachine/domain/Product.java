package vendingmachine.domain;

public class Product {
    private final String productName;
    private final ProductPrice productPrice;

    public Product(String productName, ProductPrice productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public ProductPrice getProductPrice() {
        return productPrice;
    }

    public boolean isSame(Product otherProduct) {
        return this.productName.equals(otherProduct.productName);
    }

    public boolean samePrice(Product otherProduct) {
        return this.productPrice.isSame(otherProduct.productPrice);
    }
}
