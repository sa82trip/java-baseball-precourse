package baseball.umpire;

public class Umpire {

    public String judge(String numberInComputer, String numberInUser) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < numberInComputer.length(); i++) {
            if (numberInComputer.charAt(i) == numberInUser.charAt(i)) {
                strike += 1;
                continue;
            }
            if (numberInComputer.charAt(i) != numberInUser.charAt(i)
                    && numberInComputer.contains("" + numberInUser.charAt(i))) {
                ball += 1;
            }
        }
        return String.format("%d:%d", ball, strike);
    }


}
