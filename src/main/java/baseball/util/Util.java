package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Util {
    public String makeRandomNumberInString() {
        return getStringifiedNumber();
    }

    private String getStringifiedNumber() {
        StringBuilder result = new StringBuilder();
        for (Integer number : getRandomNumber(3)) {
            result.append(number);
        }
        return result.toString();
    }

    private List<Integer> getRandomNumber(int digits) {
        int limit = 0;
        List<Integer> randomNumbers = new ArrayList<>();
        while (limit < digits) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            try{
                randomNumbers.add(barf(randomNumbers, randomNumber));
                limit++;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                getRandomNumber(digits);
            }
        }
        return randomNumbers;
    }

    private Integer barf(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("can not add duplicate number");
        }
        return number;
    }

}
