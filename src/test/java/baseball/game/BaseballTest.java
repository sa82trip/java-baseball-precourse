package baseball.game;


import static baseball.constant.BaseballStringEnum.ONE_BALL;
import static baseball.constant.BaseballStringEnum.STRIKE_IN_KOREAN;
import static baseball.constant.BaseballStringEnum.THREE_STRIKE;
import static baseball.constant.BaseballStringEnum.TWO_STRIKE;
import static baseball.constant.BaseballStringEnum.ZERO_BALL;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class BaseballTest {

    @Mock
    AutoCloseable closeable;
    @InjectMocks
    Baseball unit;

    @BeforeEach
    public void setup() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void after() throws Exception {
        closeable.close();
    }

    @Test
    @DisplayName("when user gets one ball and two strikes")
    void displayResult_() {
        assertThat(unit.displayResult(new String[]{ONE_BALL.label, TWO_STRIKE.label}))
                .contains(String.format("%s", ONE_BALL.label))
                .contains(String.format("%s%s", TWO_STRIKE.label, STRIKE_IN_KOREAN.label));

    }

    @Test
    @DisplayName("game should be finished if user gets three strikes")
    void needToFinish() {
        assertThat(unit.needToFinish(String.format("%s:%s", ZERO_BALL.label, THREE_STRIKE.label))).isTrue();
    }
}