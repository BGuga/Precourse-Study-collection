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
    }

    public void insertChangesInVendingMahcine(){
        vendingMachine.insertMoneyInCoinMachine(getChangesFromUser());
        outputView.printExchange(vendingMachine.getEnrolledCoins());
    }

    private Money getChangesFromUser() {
        return inputView.readInsertMoney();
    }
}
