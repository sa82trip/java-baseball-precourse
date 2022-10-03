package baseball.game;

import static baseball.constant.BaseballNumberEnum.INDEX_FOR_BALL;
import static baseball.constant.BaseballNumberEnum.INDEX_FOR_STRIKE;
import static baseball.constant.BaseballStringEnum.BALL_IN_KOREAN;
import static baseball.constant.BaseballStringEnum.NOTHING;
import static baseball.constant.BaseballStringEnum.STRIKE_IN_KOREAN;
import static baseball.constant.BaseballStringEnum.THREE_STRIKE;
import static baseball.constant.BaseballStringEnum.USER_INPUT_REQUEST_STATEMENT;
import static baseball.constant.BaseballStringEnum.ZERO_BALL;
import static baseball.constant.BaseballStringEnum.ZERO_STRIKE;

import baseball.player.Player;
import baseball.umpire.Umpire;
import camp.nextstep.edu.missionutils.Console;

public class Baseball {
    private final Player computer;
    private final Player user;
    private final Umpire umpire;

    public Baseball(Player computer, Player user, Umpire umpire) {
        this.computer = computer;
        this.user = user;
        this.umpire = umpire;
    }

    public void beginGame() {

        boolean finish = false;

        while (!finish) {
            System.out.print(USER_INPUT_REQUEST_STATEMENT.label + ":");
            user.setInputNumber(Console.readLine());
            String result = umpire.judge(computer.getInputNumber(), user.getInputNumber());
            System.out.println(returnStringifiedJudgeStatement(result.split(":")));
            finish = checkIfGameIsDone(result);
        }
    }

    protected String returnStringifiedJudgeStatement(String[] result) {
        String BALL_PART = result[INDEX_FOR_BALL.intValue];
        String STRIKE_PART = result[INDEX_FOR_STRIKE.intValue];
        if (isaNothing(BALL_PART, STRIKE_PART)) {
            return NOTHING.label;
        }
        if (isaZeroBall(BALL_PART)) {
            return String.format("%s%s", STRIKE_PART, STRIKE_IN_KOREAN.label);
        }
        if (isaZeroStrike(STRIKE_PART)) {
            return String.format("%s%s", BALL_PART, BALL_IN_KOREAN.label);
        }

        return String.format("%s%s %s%s", BALL_PART, BALL_IN_KOREAN.label, STRIKE_PART, STRIKE_IN_KOREAN.label);
    }

    protected boolean isaZeroStrike(String STRIKE_PART) {
        return STRIKE_PART.equals(ZERO_STRIKE.label);
    }

    protected boolean isaZeroBall(String BALL_PART) {
        return BALL_PART.equals(ZERO_BALL.label);
    }

    protected boolean isaNothing(String BALL_PART, String STRIKE_PART) {
        return isaZeroBall(BALL_PART) && isaZeroStrike(STRIKE_PART);
    }


    protected boolean checkIfGameIsDone(String judge) {
        return judge.endsWith(THREE_STRIKE.label);
    }
}

