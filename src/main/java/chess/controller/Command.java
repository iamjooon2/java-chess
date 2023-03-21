package chess.controller;

import java.util.Arrays;
import java.util.List;

enum Command {
    START("start"),
    MOVE("move"),
    END("end"),
    ;

    public static final int MOVE_COMMAND_INDEX = 0;
    public static final int MOVE_SOURCE_INDEX = 1;
    public static final int MOVE_TARGET_INDEX = 2;

    private final String value;

    Command(final String value) {
        this.value = value;
    }

    public static Command createInitCommand(final String inputCommand) {
        return getCommand(START, inputCommand);
    }

    public static Command createPlayingCommand(final String inputCommand) {
        return getCommand(MOVE, inputCommand);
    }

    private static Command getCommand(final Command possibleCommand, final String inputCommand) {
        return Arrays.stream(values())
                .filter(command -> command == possibleCommand || command == END)
                .filter(command -> command.value.equals(inputCommand))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        possibleCommand.value + " 또는 " + END.value + " 를 입력해주세요."));
    }
}
