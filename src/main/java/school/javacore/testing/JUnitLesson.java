package school.javacore.testing;


// Calculator
public class JUnitLesson {
    public int multiply(int a, int b) {
        return a * b;
    }

    public int sum(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Только положительные числа!");
        }

        return a + b;
    }
}
