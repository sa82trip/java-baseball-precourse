package baseball.game;

import static baseball.constant.BaseballStringEnum.BALL_IN_KOREAN;
import static baseball.constant.BaseballStringEnum.NOTHING;
import static baseball.constant.BaseballStringEnum.STRIKE_IN_KOREAN;
import static baseball.constant.BaseballStringEnum.THREE_STRIKE;
import static baseball.constant.BaseballStringEnum.USER_INPUT_REQUEST_STATEMENT;
import static baseball.constant.BaseballStringEnum.ZERO_BALL;
import static baseball.constant.BaseballStringEnum.ZERO_STRIKE;

import baseball.player.Player;
import baseball.umpire.Umpire;
import baseball.util.Util;
import camp.nextstep.edu.missionutils.Console;

public class Baseball {
    private final Player computer;
    private final Player user;
    private final Umpire umpire;

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
            System.out.print(USER_INPUT_REQUEST_STATEMENT.label + ":");
            user.setInputNumber(Console.readLine());
            String result = umpire.judge(computer.getInputNumber(), user.getInputNumber());
            System.out.println(returnStringifyJudgeStatement(result.split(":")));
            finish = needToFinish(result);
        }
    }

    protected String returnStringifyJudgeStatement(String[] result) {
        String BALL_PART = result[0];
        String STRIKE_PART = result[1];
        if (BALL_PART.equals(ZERO_BALL.label) && STRIKE_PART.equals(ZERO_STRIKE.label)) {
            return NOTHING.label;
        }
        if (BALL_PART.equals(ZERO_BALL.label)) {
            return String.format("%s%s", STRIKE_PART, STRIKE_IN_KOREAN.label);
        }
        if (STRIKE_PART.equals(ZERO_STRIKE.label)) {
            return String.format("%s%s", BALL_PART, BALL_IN_KOREAN.label);
        }
        return String.format("%s%s %s%s", BALL_PART, BALL_IN_KOREAN.label, STRIKE_PART, STRIKE_IN_KOREAN.label);
    }


    protected boolean needToFinish(String judge) {
        return judge.endsWith(THREE_STRIKE.label);
    }
}

