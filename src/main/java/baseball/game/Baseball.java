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
            try {
                user.setInputNumber(Console.readLine());
            } catch (IllegalArgumentException iAE) {
                System.out.println("숫자는 동일한 숫자를 포함해서는 안되며");
                System.out.println("0을 포함해서도 안됩니다");
                System.out.print("숫자를 입력해주세요:");
                user.setInputNumber(Console.readLine());
            }
            System.out.println(umpire.judge(computer.getInputNumber(), user.getInputNumber()));
        }
    }
}

