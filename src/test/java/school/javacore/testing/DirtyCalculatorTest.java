package school.javacore.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirtyCalculatorTest {

    @Test
    void shouldReturnSumOperationCorrectResult() {
        // given
        Calculator calculator = getCalculator();

        // when
        int result = calculator.sum(2, 3);

        // then
        assertEquals(5, result);
    }

    @Test
    void shouldReturnSubtractOperationCorrectResult() {
        // given
        Calculator calculator = getCalculator();

        // when
        int result = calculator.subtract(3, 2);

        // then
        assertEquals(1, result);
    }

    @Test
    void shouldReturnMultiplyOperationCorrectResult() {
        // given
        Calculator calculator = getCalculator();

        // when
        int result = calculator.multiply(2, 3);

        // then
        assertEquals(6, result);
    }

    Calculator getCalculator() {
        return new Calculator();
    }
}
