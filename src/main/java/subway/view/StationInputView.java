package subway.view;

import subway.controller.StationCommand;

import java.util.Scanner;

public class StationInputView {

    private Scanner scanner = new Scanner(System.in);

    public StationCommand getCommandByConsole() {
        printValidList();
        while (true) {
            try {
                printSelectFunctionMessage();
                return StationCommand.of(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String getStationNameByConsole() {
        printEnrollStationMessage();
        return scanner.nextLine();
    }

    private void printValidList() {
        System.out.println("## 역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기");
        System.out.println();
    }

    private void printSelectFunctionMessage() {
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    private void printEnrollStationMessage(){
        System.out.println("## 등록할 역 이름을 입력하세요.");
    }
}
