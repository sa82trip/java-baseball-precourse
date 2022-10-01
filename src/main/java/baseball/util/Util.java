package baseball.util;

import static baseball.Application.DIGIT_FOR_GAME;
import static baseball.constant.BaseballNumberEnum.NUMBER_END;
import static baseball.constant.BaseballNumberEnum.NUMBER_START;

import baseball.constant.BaseballNumberEnum;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class Util {

    public String makeRandomNumberInString() {
        StringBuilder result = new StringBuilder();
        for (Integer number : getRandomNumbers(DIGIT_FOR_GAME)) {
            result.append(number);
        }
        return result.toString();
    }

    private Set<Integer> getRandomNumbers(int numberOfDigits) {
        Set<Integer> randomNumbers = new HashSet<>();
        while (randomNumbers.size() < numberOfDigits) {
            randomNumbers.add(Randoms.pickNumberInRange(NUMBER_START.intValue, NUMBER_END.intValue));
        }
        return randomNumbers;
    }

    public static String getSubstring(String inputNumber) {
        return inputNumber.substring(BaseballNumberEnum.INDEX_ONE.intValue);
    }

    public static String getFirstLetter(String inputNumber) {
        return String.valueOf(inputNumber.charAt(BaseballNumberEnum.INDEX_ZERO.intValue));
    }

}
