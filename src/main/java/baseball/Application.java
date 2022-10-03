package baseball;

import static baseball.constant.BaseballNumberEnum.MAX_DIGIT;
import static baseball.constant.BaseballStringEnum.END_GAME;
import static baseball.constant.BaseballStringEnum.NEW_GAME;

import baseball.game.Baseball;
import baseball.util.Util;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static Integer DIGIT_FOR_GAME = MAX_DIGIT.intValue;
    public static final Util util = new Util();

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String flg = NEW_GAME.label;
        while (flg.equals(NEW_GAME.label)) {
            Baseball baseball = util.getBaseballWithRandomNumber();
            baseball.beginGame(false);
            System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료%n", DIGIT_FOR_GAME);
            System.out.printf("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요%n", NEW_GAME.label, END_GAME.label);
            flg = Console.readLine();
        }
        System.out.println("게임 종료");
    }
}
