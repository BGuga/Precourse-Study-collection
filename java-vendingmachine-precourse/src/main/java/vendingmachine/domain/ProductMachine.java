package vendingmachine.domain;

import javax.swing.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ProductMachine {

    public static final String PRODUCT_PRICE_DIFFERENCE_ERROR_MESSAGE = "[ERROR] 등록된 상품의 가격이 다를 수 없습니다.";
    private Map<Product, ProductAmount> storage = new HashMap<>();

    public void addProducts(ProductBundle productBundle) {
        Map<Product, ProductAmount> additionalProduct = productBundle.getProducts();
        for (Product product : additionalProduct.keySet()) {
            addProduct(product, additionalProduct.get(product));
        }
    }

    public Product getProductOf(String productName) {
        return storage.keySet().stream()
                .filter(product -> product.getProductName().equals(productName))
                .findAny()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("[ERROR] 등록되지 않은 상품 입니다.");
                });
    }

    public boolean canBuyAnything(Money money) {
        ProductPrice minProductPrice = storage.keySet().stream()
                .map(product -> product.getProductPrice())
                .sorted(Comparator.comparing(ProductPrice::getPrice))
                .findFirst()
                .get();
        return money.getMoney() > minProductPrice.getPrice();
    }

    public void deleteOne(Product product) {
        checkProductCount(product);
        ProductAmount productAmount = storage.get(product);
        productAmount.sub(1);
    }

    private void addProduct(Product product, ProductAmount productAmount) {
        if (haveProduct(product)) {
            checkProductPrice(product);
            increaseProductAmount(product, productAmount);
            return;
        }
        enrollProduct(product, productAmount);
    }

    private boolean haveProduct(Product product) {
        return storage.keySet().stream().anyMatch(st -> st.isSame(product));
    }

    private void checkProductPrice(Product product) {
        Product enrolledProduct = getEnrolledProductOf(product);
        if (!product.samePrice(enrolledProduct)) {
            throw new IllegalArgumentException(PRODUCT_PRICE_DIFFERENCE_ERROR_MESSAGE);
        }
    }

    private void increaseProductAmount(Product product, ProductAmount productAmount) {
        Product enrolledProduct = getEnrolledProductOf(product);
        ProductAmount enrolledProductAmount = storage.get(enrolledProduct);
        enrolledProductAmount.add(productAmount);
    }

    private Product getEnrolledProductOf(Product product) {
        return storage.keySet().stream()
                .filter(pr -> pr.isSame(product))
                .findAny()
                .get();
    }

    private void enrollProduct(Product product, ProductAmount productAmount) {
        storage.put(product, productAmount);
    }

    private void checkProductCount(Product product) {
        if (storage.get(product).getAmount() < 1) {
            throw new IllegalArgumentException("[ERROR] 수량이 떨어진 상품은 구매할 수 없습니다.");
        }
    }
}
