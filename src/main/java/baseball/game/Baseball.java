package baseball.game;

import baseball.player.Player;
import camp.nextstep.edu.missionutils.Console;

public class Baseball {
    Player computer;
    Player user;

    public Baseball(Player computer, Player user) {
        this.computer = computer;
        this.user = user;
    }

    public void beginGame() {

        boolean finish = false;

        //TODO: add determiner to finish baseball game
        while (!finish) {
            System.out.print("숫자를 입력해주세요:");
            user.setInputNumber(Console.readLine());
        }
    }
}

