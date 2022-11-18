package bridge.domain;

import bridge.dto.GameResult;
import bridge.dto.UserState;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String MOVING_ERROR_MESSAGE = "[ERROR] 유저가 이동할 수 없는 상태입니다.";

    private Bridge bridge;
    private int userPosition;
    private boolean aliveUser;
    private boolean needToQuit;
    private int numberOfAttempts;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.userPosition = 0;
        this.aliveUser = true;
        this.needToQuit = false;
        this.numberOfAttempts = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Direction direction) {
        movingValidation();
        userPosition++;
        checkLife(direction);
    }

    private void movingValidation() {
        if (!aliveUser || bridge.isEndOfBridge(userPosition)) {
            throw new IllegalArgumentException(MOVING_ERROR_MESSAGE);
        }
    }

    public boolean isEndGame() {
        if (!aliveUser || successGame()) {
            return true;
        }
        return false;
    }

    public boolean isNeedToQuit() {
        if (successGame()) {
            needToQuit = true;
        }
        return needToQuit;
    }

    public UserState getProgressUserState() {
        return new UserState(bridge, userPosition, aliveUser);
    }

    public GameResult getGameResult() {
        return new GameResult(getProgressUserState(),successGame(),numberOfAttempts);
    }

    private void checkLife(Direction direction) {
        if (!bridge.isCorrectDirection(direction, userPosition)) {
            aliveUser = false;
        }
    }

    private boolean successGame() {
        if (bridge.isEndOfBridge(userPosition) && aliveUser) {
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(Command command) {
        if (command == Command.Restart) {
            settingForRestart();
        }
        if (command == Command.Quit) {
            settingForQuit();
        }
    }

    private void settingForRestart() {
        userPosition = 0;
        numberOfAttempts++;
        aliveUser = true;
    }

    private void settingForQuit() {
        needToQuit = true;
    }
}
