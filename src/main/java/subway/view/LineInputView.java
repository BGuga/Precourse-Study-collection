package subway.view;

import subway.controller.LineCommand;
import subway.controller.StationCommand;

import java.util.Scanner;

public class LineInputView {

    private Scanner scanner = new Scanner(System.in);

    public LineCommand getCommandByConsole() {
        printValidList();
        while (true) {
            try {
                printSelectFunctionMessage();
                return LineCommand.of(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String getLineNameByConsole() {
        System.out.println("## 등록할 노선 이름을 입력하세요.");
        System.out.println();
        return scanner.nextLine();
    }

    public String getStartStation() {
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        System.out.println();
        return scanner.nextLine();
    }

    public String getEndStation() {
        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        System.out.println();
        return scanner.nextLine();
    }

    public String getDeleteLineNameByConsole() {
        System.out.println("## 삭제할 노선 이름을 입력하세요.");
        System.out.println();
        return scanner.nextLine();
    }

    private void printValidList() {
        System.out.println("## 노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기");
        System.out.println();
    }

    private void printSelectFunctionMessage() {
        System.out.println("## 원하는 기능을 선택하세요.");
    }
}
