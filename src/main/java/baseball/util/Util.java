package baseball.util;

import baseball.constant.BaseballNumberEnum;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class Util {
    int NUMBER_OF_DIGITS = 3;
    int NUMBER_START = 1;
    int NUMBER_END = 9;

    public String makeRandomNumberInString() {
        StringBuilder result = new StringBuilder();
        for (Integer number : getRandomNumbers(NUMBER_OF_DIGITS)) {
            result.append(number);
        }
        return result.toString();
    }

    private Set<Integer> getRandomNumbers(int numberOfDigits) {
        Set<Integer> randomNumbers = new HashSet<>();
        while (randomNumbers.size() < numberOfDigits) {
            randomNumbers.add(Randoms.pickNumberInRange(NUMBER_START, NUMBER_END));
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
