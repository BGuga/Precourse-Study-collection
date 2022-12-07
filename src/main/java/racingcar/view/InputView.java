package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public List<Car> readCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = splitByComma(Console.readLine());
        return makeStringListToCarList(carNames);
    }

    private List<String> splitByComma(String data) {
        return Arrays.asList(data.split(","));
    }

    private List<Car> makeStringListToCarList(List<String> carName) {
        return carName.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
