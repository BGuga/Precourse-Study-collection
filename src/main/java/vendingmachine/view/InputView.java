package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

import vendingmachine.domain.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputView {
    public Money readChangesAmount() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        try {
            return new Money(getIntValue());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readChangesAmount();
        }
    }

    public ProductBundle readProductBundle() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        try{
            Map<Product, ProductAmount> productData = getProductData();
            return new ProductBundle(productData);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readProductBundle();
        }
    }

    private int getIntValue() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요");
            return getIntValue();
        }
    }

    private Map<Product, ProductAmount> getProductData() {
        try {
            Map<Product, ProductAmount> result = new HashMap<>();
            List<String> productInformation = getProductInfo();
            for (String info : productInformation) {
                insertResult(result, info);
            }
            return result;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getProductData();
        }
    }

    private List<String> getProductInfo() {
        try {
            List<String> listData = Arrays.asList(Console.readLine().split(";"));
            checkInfoValidation(listData);
            return listData;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getProductInfo();
        }
    }

    private void checkInfoValidation(List<String> informations) {
        for (String info : informations) {
            checkFormat(info);
        }
    }

    private void checkFormat(String info) {
        if (info.startsWith("[") || info.endsWith("]")) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 상품 데이터는 [와 ]로 감싸주어야 합니다.");
    }

    private void insertResult(Map<Product, ProductAmount> map, String info) {
        checkvalidInfoData(info);
        try {
            List<String> data = Arrays.asList(info.split(","));
            map.put(new Product(data.get(0), new ProductPrice(Integer.parseInt(data.get(1)))), new ProductAmount(Integer.parseInt(data.get(2))));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 상품 가격과 수량은 숫자로 입력해 주세요");
        }
    }

    private void checkvalidInfoData(String info) {
        if (info.split(",").length != 3) {
            throw new IllegalArgumentException("[ERROR] 상품 등록에 누락된 정보가 있습니다.");
        }
    }
}
