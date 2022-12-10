package vendingmachine.domain;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductBundle {

    public static final String UNIQUE_PRODUCT_ERROR_MESSAGE = "[ERROR] 제품 묶음 속 같은 제품이 여러개로 분할 될 수 없습니다.";
    private final Map<Product, ProductAmount> products;

    public ProductBundle(Map<Product, ProductAmount> products) {
        this.products = products;
        validateProducts();
    }

    private void validateProducts() {
        long uniqueProductCount = products.keySet().stream()
                .map(product -> product.getProductName())
                .distinct()
                .count();
        if(products.size()!=uniqueProductCount){
            throw new IllegalArgumentException(UNIQUE_PRODUCT_ERROR_MESSAGE);
        }
    }
}
