package baseball.umpire;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class UmpireTest {

    @Test
    void judge_three_strike() {
        Umpire unit = new Umpire();
        assertThat(unit.judge("123", "123")).startsWith("0").contains("3");
    }

    @Test
    void judge_three_ball() {
        Umpire unit = new Umpire();
        assertThat(unit.judge("123", "312")).startsWith("3").contains("0");
    }

    @Test
    void judge_two_ball_one_strike() {
        Umpire unit = new Umpire();
        assertThat(unit.judge("123", "213")).startsWith("2").contains("1");
    }

    @Test
    void judge_nothing() {
        Umpire unit = new Umpire();
        assertThat(unit.judge("123", "456")).startsWith("0").endsWith("0");
    }

    @Test
    void isABall() {
        Umpire unit = new Umpire();
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            ball += unit.isABall("123", "256", i);
        }
        assertThat(ball).isEqualTo(1);
    }

    @Test
    void isAStrike() {
        Umpire unit = new Umpire();
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            strike += unit.isAStrike("123", "423", i);
        }
        assertThat(strike).isEqualTo(2);
    }
}