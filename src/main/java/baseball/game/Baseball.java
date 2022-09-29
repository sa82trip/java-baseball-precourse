package baseball.game;

import baseball.player.Player;
import baseball.umpire.Umpire;
import camp.nextstep.edu.missionutils.Console;

public class Baseball {
    Player computer;
    Player user;
    Umpire umpire;

    public Baseball(Player computer, Player user, Umpire umpire) {
        this.computer = computer;
        this.user = user;
        this.umpire = umpire;
    }

    public void beginGame() {

        boolean finish = false;

        //TODO: add determiner to finish baseball game
        while (!finish) {
            System.out.print("숫자를 입력해주세요:");
            user.setInputNumber(Console.readLine());
            System.out.println(umpire.judge(computer.getInputNumber(), user.getInputNumber()));
        }
    }
}

