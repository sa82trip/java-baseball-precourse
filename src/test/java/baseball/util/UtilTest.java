package baseball.util;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class UtilTest {

    @Test
    void makeRandomNumberInString() {
        Util util = new Util();
        String numberInString = util.makeRandomNumberInString();
        System.out.println(numberInString);
        List<Character> numberInChar = numberInString.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
        assertThat(numberInChar).doesNotContain('0');
        assertThat(numberInChar).size().isEqualTo(3);
        char removed = numberInChar.remove(0);
        System.out.println(removed);
        assertThat(numberInChar).doesNotContain(removed);
    }

    @Test
    public void validationTest() {
        int count = 0;
        while (count < 100) {
            makeRandomNumberInString();
            System.out.printf("count: %d %n", count);
            count++;
        }
    }
}