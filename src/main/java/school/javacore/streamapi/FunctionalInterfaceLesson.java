package school.javacore.streamapi;

/*
Реализуйте следующий код:
Создайте интерфейс MyCalculator с методом double calculate(double a, double b),
помеченный аннотацией @FunctionalInterface.
Создайте класс Main с методом testCalculator(MyCalculator calc), который принимает два числа,
вызывает метод calculate и выводит результат.
В методе main создайте два объекта MyCalculator:
Один реализуйте через анонимный класс, который выполняет сложение.
Второй реализуйте через лямбда-выражение, который выполняет сложение.

Вызовите testCalculator() для обоих объектов, передав числа 10 и 5, и убедитесь, что результаты совпадают.
*/

public class FunctionalInterfaceLesson {
    public static void main(String[] args) {
        MyCalculator calculator = new MyCalculator() {
            @Override
            public double calculate(double a, double b) {
                return a + b;
            }
        };

        MyCalculator calculator2 = (a, b) -> a + b;

        testCalculator(calculator, 10, 5);
        testCalculator(calculator2, 10, 5);
    }

    public static void testCalculator(MyCalculator calc, double a, double b) {
        double result = calc.calculate(a, b);
        System.out.println("Result: " + result);
    }
}

@FunctionalInterface
interface MyCalculator {
    double calculate(double a, double b);
}
