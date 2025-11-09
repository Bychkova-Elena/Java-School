package school.javacore.testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JUnitLessonTest {

    @Test
    public void shouldReturnCorrectSum() {
        // given
        JUnitLesson calc = new JUnitLesson();

        // when
        int result = calc.sum(2, 3);

        // then
        assertEquals(5, result);
    }

    @Test
    public void shouldThrowExceptionWhenSumIsNegative() {
        // given
        JUnitLesson calc = new JUnitLesson();

        // when & then
        assertThrows(IllegalArgumentException.class, () -> calc.sum(-2, -1));
    }

    @Test
    public void shouldReturnCorrectMultiplication() {
        // given
        JUnitLesson calc = new JUnitLesson();

        // when
        int result = calc.multiply(2, 3);

        // then
        assertEquals(6, result);
    }

    @Test
    public void shouldTReturnCorrectMultiplicationWhenOneIsZero() {
        // given
        JUnitLesson calc = new JUnitLesson();

        // when
        int result = calc.multiply(0, 5);

        // then
        assertEquals(0, result);
    }

}
