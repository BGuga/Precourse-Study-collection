package baseball.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BallReader {
    private static String BALL = "BALL";
    private static String STRIKE = "STRIKE";
    private static String MISS = "MISS";
    private int requiredStrikes;

    public BallReader() {
        this.requiredStrikes = 3;
    }

    public boolean isFinished(Ball userBall, Ball computerBall) {
        Map<String, Integer> result = getStrikeAndBall(userBall, computerBall);
        if (result.get(STRIKE) == null) {
            return false;
        }
        return result.get(STRIKE) == requiredStrikes;
    }

    public Map<String, Integer> getStrikeAndBall(Ball userBall, Ball computerBall) {
        validateBalls(userBall, computerBall);
        List<String> strikeAndBall = makeStrikeAndBall(userBall, computerBall);
        return makeMapByStrikeAndBall(strikeAndBall);
    }

    private List<String> makeStrikeAndBall(Ball userBall, Ball computerBall) {
        List<String> strikeAndBallResult = new ArrayList<>();

        List<Integer> userBallData = userBall.getBallData();
        List<Integer> computerBallData = computerBall.getBallData();

        for (int number : userBallData) {
            int userIndex = userBallData.indexOf(number);
            int computerIndex = computerBallData.indexOf(number);
            String result = judgeStrikeAndBall(userIndex, computerIndex);
            strikeAndBallResult.add(result);
        }
        return strikeAndBallResult;
    }

    private String judgeStrikeAndBall(int userIndex, int computerIndex){
        final int noNumberInComputer = -1;
        if (userIndex == computerIndex) {
            return STRIKE;
        }
        if (userIndex != computerIndex && computerIndex != noNumberInComputer) {
            return BALL;
        }
        return MISS;
    }

    private Map<String, Integer> makeMapByStrikeAndBall(List<String> ballData) {
        Map<String, Integer> result = new HashMap<>();
        for (String data : ballData) {
            result.computeIfPresent(data, (key, value) -> value + 1);
            result.computeIfAbsent(data, key -> 1);
        }
        return result;
    }

    private void validateBalls(Ball userBall, Ball computerBall) {
        List<Integer> userBallData = userBall.getBallData();
        List<Integer> computerBallData = computerBall.getBallData();
        if (userBallData.size() != computerBallData.size()) {
            throw new IllegalArgumentException("서로 호환 되지 않는 공입니다");
        }
    }
}
