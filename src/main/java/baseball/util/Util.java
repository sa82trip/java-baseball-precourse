package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

public class Util {
    public static String makeRandomNumberInString() {
        int limit = 0;
        StringBuilder randomNumber = new StringBuilder();
        while (limit < 3) {
            randomNumber.append(Randoms.pickNumberInRange(1, 9));
            limit++;
        }
        return randomNumber.toString();
    }
}
