package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Money;

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

    private int getIntValue() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요");
            return getIntValue();
        }
    }
}
