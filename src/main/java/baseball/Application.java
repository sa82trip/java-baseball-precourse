package baseball;

import baseball.game.Baseball;
import baseball.player.Player;
import baseball.umpire.Umpire;
import baseball.util.Util;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    private final static String NEW_GAME = "1";
    private final static String END_GAME = "2";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Util util = new Util();
        Player computer = new Player();
        Player user = new Player();
        Umpire umpire = new Umpire();
        Baseball baseball = new Baseball(computer, user, umpire, util);

        String flg = NEW_GAME;
        while (flg.equals(NEW_GAME)) {
            baseball.beginGame();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.printf("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요%n", NEW_GAME, END_GAME);
            flg = Console.readLine();
        }
        System.out.println("게임 종료");
//        System.exit(0);
    }
}
