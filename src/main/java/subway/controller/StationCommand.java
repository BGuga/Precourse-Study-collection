package subway.controller;

import java.util.Arrays;

public enum StationCommand {
    ENROLL("1"),
    DELETE("2"),
    SEARCH("3"),
    BACK("B");

    public static final String NOT_EXITING_COMMAND_MESSAGE = "[ERROR] 존재 하지 않는 커맨드 입력입니다.";

    private final String commandString;

    StationCommand(String commandString) {
        this.commandString = commandString;
    }

    public static StationCommand of(String command) {
        return Arrays.stream(values())
                .filter(cmd -> cmd.commandString.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXITING_COMMAND_MESSAGE));
    }
}
