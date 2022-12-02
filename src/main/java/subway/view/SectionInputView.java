package subway.view;

import subway.controller.LineCommand;
import subway.controller.SectionCommand;

import java.util.Scanner;

public class SectionInputView {

    private Scanner scanner = new Scanner(System.in);

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
}
