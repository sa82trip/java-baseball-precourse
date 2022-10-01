package baseball.umpire;

public class Umpire {

    public String judge(String numberInComputer, String numberInUser) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < numberInComputer.length(); i++) {
            strike += isAStrike(numberInComputer, numberInUser, i);
            ball += isABall(numberInComputer, numberInUser, i);
        }
        return String.format("%d:%d", ball, strike);
    }

    protected int isABall(String numberInComputer, String numberInUser, int i) {
        if (numberInComputer.charAt(i) != numberInUser.charAt(i)
                && numberInComputer.contains(String.valueOf(numberInUser.charAt(i)))) {
            return 1;
        }
        return 0;
    }

    protected int isAStrike(String numberInComputer, String numberInUser, int i) {
        if (numberInComputer.charAt(i) == numberInUser.charAt(i)) {
            return 1;
        }
        return 0;
    }
}
