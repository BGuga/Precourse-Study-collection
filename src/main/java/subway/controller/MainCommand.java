package subway.controller;

import java.util.Arrays;

public enum MainCommand {
    STATION_MANAGEMENT("1"),
    LINE_MANAGEMENT("2"),
    SECTION_MANAGEMENT("3"),
    PRINT_MAP("4"),
    QUIT("Q");

    public static final String NOT_EXITING_COMMAND_MESSAGE = "[ERROR] 선택할 수 없는 기능입니다.";

    private final String command;

    MainCommand(String command) {
        this.command = command;
    }

    public static MainCommand of(String command) {
        return Arrays.stream(values())
                .filter(cmd -> cmd.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXITING_COMMAND_MESSAGE));
    }
}
