package baseball.game;

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
        if (ballPart.contains("0") && strikePart.contains("0")) {
            return "낫싱";
        }
        if (ballPart.contains("0") && !strikePart.contains("0")) {
            return strikePart;
        }
        if (strikePart.contains("0") && !ballPart.contains("0")) {
            return ballPart;
        }
        return ballPart + " " + strikePart;
    }


    protected boolean needToFinish(String judge) {
        return judge.endsWith("3");
    }
}

