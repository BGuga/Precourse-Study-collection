package racingcar.dto;

import java.util.List;

public class MultiPosition {
    private final List<Position> positions;

    public MultiPosition(List<Position> positions) {
        this.positions = positions;
    }

    public List<Position> getPositions() {
        return positions;
    }
}
