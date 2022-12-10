package vendingmachine.controller;

import vendingmachine.domain.Money;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    VendingMachine vendingMachine = new VendingMachine();

    public void process() {
        insertChangesInVendingMahcine();
        insertProductInVendingMachine();
        insertMoneyInVendingMachine();
        buyUntilAvaliable();
    }

    private void insertChangesInVendingMahcine() {
        vendingMachine.insertMoneyInCoinMachine(getChangesFromUser());
        outputView.printExchange(vendingMachine.getEnrolledCoins());
    }

    private void insertProductInVendingMachine() {
        vendingMachine.addProductBundle(inputView.readProductBundle());
    }

    private void insertMoneyInVendingMachine() {
        vendingMachine.insertMoney(inputView.readInsertMoney());
    }

    private void buyUntilAvaliable() {
        while (vendingMachine.canBuy()) {
            outputView.printInsertedMoney(vendingMachine.getInsertedMoney());
            buyProduct(inputView.readProductName());
        }
        outputView.printReceivedCoins(vendingMachine.getChanges());
    }

    private Money getChangesFromUser() {
        return inputView.readInsertMoney();
    }

    private void buyProduct(String productName) {
        try {
            vendingMachine.buy(productName);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }

    }
}
