package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoResultTest {

    private LottoResult lottoResult = new LottoResult();
    static Map<LottoRanking, Integer> firstData = new HashMap<>();
    static Map<LottoRanking, Integer> secondData = new HashMap<>();
    static Map<LottoRanking, Integer> thirdData = new HashMap<>();
    @BeforeEach
    void valueSetting(){
        firstData.put(LottoRanking.FIRST, 1);
        firstData.put(LottoRanking.SECOND, 2);
        firstData.put(LottoRanking.THIRD, 3);
        firstData.put(LottoRanking.FOURTH, 4);
        firstData.put(LottoRanking.FIFTH, 5);
        firstData.put(LottoRanking.MISS, 6);

        secondData.put(LottoRanking.FIRST, 0);
        secondData.put(LottoRanking.SECOND, 0);
        secondData.put(LottoRanking.THIRD, 2);
        secondData.put(LottoRanking.FOURTH, 5);
        secondData.put(LottoRanking.FIFTH, 6);
        secondData.put(LottoRanking.MISS, 8);

        thirdData.put(LottoRanking.FIRST, 0);
        thirdData.put(LottoRanking.SECOND, 0);
        thirdData.put(LottoRanking.THIRD, 0);
        thirdData.put(LottoRanking.FOURTH, 0);
        thirdData.put(LottoRanking.FIFTH, 1);
        thirdData.put(LottoRanking.MISS, 7);
    }

    @DisplayName("로또 장수 계산 기능 테스트")
    @ParameterizedTest
    @MethodSource("lottoRankingTicketDataSource")
    void 로또_장수_계산_테스트(Map<LottoRanking, Integer> lottoData, int expected) {

        assertThat(lottoResult.getTotalTicket(lottoData)).isEqualTo(expected);
    }

    @DisplayName("로또 상금 계산 기능 테스트")
    @ParameterizedTest
    @MethodSource("lottoRankingRewardDataSource")
    void 로또_상금_계산_테스트(Map<LottoRanking, Integer> lottoData, int expected) {
        assertThat(lottoResult.getTotalReward(lottoData)).isEqualTo(expected);
    }

    private static Stream<Arguments> lottoRankingTicketDataSource() {
        return Stream.of(
                Arguments.of(firstData, 21),
                Arguments.of(secondData, 21),
                Arguments.of(thirdData, 8)
        );
    }

    private static Stream<Arguments> lottoRankingRewardDataSource() {
        return Stream.of(
                Arguments.of(firstData, 2064725000),
                Arguments.of(secondData, 3280000),
                Arguments.of(thirdData, 5000)
        );
    }
}