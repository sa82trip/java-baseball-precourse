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
        String BALL_PART = result[0];
        String STRIKE_PART = result[1];
        if (BALL_PART.equals(ZERO_BALL.label) && STRIKE_PART.equals(ZERO_STRIKE.label)) {
            return NOTHING.label;
        }
        if (BALL_PART.equals(ZERO_BALL.label)) {
            return String.format("%s스트라이크", STRIKE_PART);
        }
        if (STRIKE_PART.equals(ZERO_STRIKE.label)) {
            return String.format("%s볼", BALL_PART);
        }
        return String.format("%s볼 %s스트라이크", BALL_PART, STRIKE_PART);
    }


    protected boolean needToFinish(String judge) {
        return judge.endsWith(THREE_STRIKE.label);
    }
}

