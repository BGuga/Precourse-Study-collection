package subway.view;

import subway.controller.LineCommand;
import subway.controller.MainCommand;

import java.util.Scanner;

public class MainInputView {
    private Scanner scanner = new Scanner(System.in);

    public MainCommand getCommandByConsole() {
        printValidList();
        while (true) {
            try {
                printSelectFunctionMessage();
                return MainCommand.of(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printValidList() {
        System.out.println("## 메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료");
        System.out.println();
    }

    private void printSelectFunctionMessage() {
        System.out.println("## 원하는 기능을 선택하세요.");
    }

}
