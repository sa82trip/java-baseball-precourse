package baseball.player;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    @DisplayName("number which is not 3-digit number should result to get False")
    void validateInputFalse() {
        Player unit = new Player();
        assertThat(unit.validateInput("1234")).isFalse();
    }

    @Test
    @DisplayName("number which is 3-digit number should result to get True")
    void validateInputSuccess() {
        Player unit = new Player();
        assertThat(unit.validateInput("123")).isTrue();
    }

    @Test
    @DisplayName("setting number which is not 3-digit to model should result IllegalArgumentException")
    void setInputNumber() {
        Player unit = new Player();
        assertThrows(IllegalArgumentException.class, () -> unit.setInputNumber("1234"));
    }
}