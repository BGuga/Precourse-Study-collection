package subway.view;

import subway.controller.LineCommand;
import subway.controller.SectionCommand;

import java.util.Scanner;

public class SectionInputView {

    private Scanner scanner = new Scanner(System.in);
    private SectionOutputView outputView = new SectionOutputView();

    public SectionCommand getCommandByConsole() {
        printValidList();
        while (true) {
            try {
                printSelectFunctionMessage();
                return SectionCommand.of(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String getLineNameByConsole() {
        System.out.println("## 노선을 입력하세요.");
        System.out.println();
        return scanner.nextLine();
    }

    public String getStationByConsole() {
        System.out.println("## 역이름을 입력하세요.");
        System.out.println();
        return scanner.nextLine();
    }

    public int getStationIndex() {
        try {
            System.out.println("## 순서를 입력하세요.");
            int order = scanner.nextInt();
            checkStationOrder(order);
            return order - 1;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getStationIndex();
        }
    }

    private void printValidList() {
        System.out.println("## 구간 관리 화면");
        System.out.println("1. 구간 등록");
        System.out.println("2. 구간 삭제");
        System.out.println("B. 돌아가기");
        System.out.println();
    }

    private void printSelectFunctionMessage() {
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    private void checkStationOrder(int order) {
        if (order < 0) {
            throw new IllegalArgumentException("[ERROR] 역의 순서는 양수의 값으로 입력해야 합니다.");
        }
    }
}
