package baseball;

import baseball.game.Baseball;
import baseball.player.Player;
import baseball.util.Util;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Util util = new Util();
        Player computer = new Player();
        computer.setThreeDigitNumber(util.makeRandomNumberInString());
        Player user = new Player();
        Baseball baseball = new Baseball(computer, user);
        baseball.beginGame();
    }
}
