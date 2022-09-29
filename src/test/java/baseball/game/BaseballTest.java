package baseball.game;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class BaseballTest {

    final String ZERO_BALL = "0";
    final String ONE_BALL = "1";
    final String TWO_BALL = "2";
    final String THREE_BALL = "3";
    final String ZERO_STRIKE = "0";
    final String ONE_STRIKE = "1";
    final String TWO_STRIKE = "2";
    final String THREE_STRIKE = "3";
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
        assertThat(unit.displayResult(new String[]{ONE_BALL, TWO_STRIKE})).contains("1볼").contains("2스트라이크");
    }

    @Test
    @DisplayName("game should be finished if user gets three strikes")
    void needToFinish() {
        assertThat(unit.needToFinish(String.format("%s:%s", ZERO_BALL, THREE_STRIKE))).isTrue();
    }
}