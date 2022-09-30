package baseball.game;

import static baseball.constant.BaseballStringEnum.NOTHING;
import static baseball.constant.BaseballStringEnum.THREE_STRIKE;
import static baseball.constant.BaseballStringEnum.ZERO_BALL;
import static baseball.constant.BaseballStringEnum.ZERO_STRIKE;

import baseball.player.Player;
import baseball.umpire.Umpire;
import baseball.util.Util;
import camp.nextstep.edu.missionutils.Console;

public class Baseball {
    Player computer;
    Player user;
    Umpire umpire;

    Util util;

    public Baseball(Player computer, Player user, Umpire umpire, Util util) {
        this.computer = computer;
        this.user = user;
        this.umpire = umpire;
        this.util = util;
    }

    public void beginGame() {

        boolean finish = false;

        computer.setInputNumber(util.makeRandomNumberInString());

        while (!finish) {
            System.out.print("숫자를 입력해주세요:");
            user.setInputNumber(Console.readLine());
            String result = umpire.judge(computer.getInputNumber(), user.getInputNumber());
            System.out.println(displayResult(result.split(":")));
            finish = needToFinish(result);
        }
    }

    protected String displayResult(String[] result) {
        String ballPart = String.format("%s볼", result[0]);
        String strikePart = String.format("%s스트라이크", result[1]);
        if (ballPart.contains(ZERO_BALL.label) && strikePart.contains(ZERO_STRIKE.label)) {
            return NOTHING.label;
        }
        if (ballPart.contains(ZERO_BALL.label) && !strikePart.contains(ZERO_STRIKE.label)) {
            return strikePart;
        }
        if (strikePart.contains(ZERO_STRIKE.label) && !ballPart.contains(ZERO_BALL.label)) {
            return ballPart;
        }
        return ballPart + " " + strikePart;
    }


    protected boolean needToFinish(String judge) {
        return judge.endsWith(THREE_STRIKE.label);
    }
}

