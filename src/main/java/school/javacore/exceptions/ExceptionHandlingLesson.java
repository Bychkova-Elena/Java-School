package school.javacore.exceptions;

/*
Задание: Напишите программу, с определенными требованиям:

Требования к программе:
Ввод данных:
Программа запрашивает у пользователя два числа.
Если ввод некорректен (например, введена строка вместо числа), необходимо перехватить исключение InputMismatchException
и вывести сообщение об ошибке.
Выполнение операции деления:
Программа делит первое число на второе.
Если происходит деление на ноль, программа перехватывает исключение ArithmeticException и выводит сообщение об ошибке.
Логгирование:
Все ошибки (деление на ноль, неверный ввод) логируются в консоль с использованием java.util.logging на уровне SEVERE.
Успешное выполнение операции деления логируется с уровнем INFO.
Многократное выполнение:
После выполнения операции (успешной или с ошибкой) программа должна спрашивать пользователя, хочет ли он выполнить
ещё одну операцию.
Если пользователь выбирает продолжение, программа повторяет процесс ввода и вычисления.
Если пользователь отказывается, программа завершается.
История операций:
Программа должна сохранять описание каждой операции
(например, «Деление 10.0 / 0.0 завершилось ошибкой: деление на ноль» или «Деление 20.0 / 4.0 = 5.0»).
По завершении работы программы выводится полный список операций с их результатами или описанием ошибки.
*/


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

public class ExceptionHandlingLesson {
    private static final Logger logger = Logger.getLogger(ExceptionHandlingLesson.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<String>();
        double firstNumber = 0;
        double secondNumber = 0;

        boolean repeat = true;

        while (repeat) {
            try {
                System.out.print("Введите первое число: ");
                firstNumber = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("Введите второе число: ");
                secondNumber = scanner.nextDouble();
                scanner.nextLine();

                double result = division(firstNumber, secondNumber, arrayList);
                System.out.println("Результат деления: " + result);
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: некорректное число!");
                logger.log(Level.SEVERE, "Ошибка: некорректное число!", e);
                arrayList.add("Деление завершилось ошибкой: некорректное число!");
                scanner.nextLine();
            } catch (ArithmeticException e) {
                System.out.println("Ошибка: деление на ноль!");
                logger.log(Level.SEVERE, "Ошибка: деление на ноль!", e);
                arrayList.add(
                        "Деление " + firstNumber + " / " + secondNumber + " завершилось ошибкой: деление на ноль"
                );
                scanner.nextLine();
            } finally {
                repeat = giveQuestion(scanner);
            }
        }

        scanner.close();
        System.out.println("История операций:");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(i+1 + ". " + arrayList.get(i));
        }

        System.out.println("Программа завершена.");
    }

    private static double division(double firstNumber, double secondNumber, ArrayList<String> arrayList) {
        if (secondNumber == 0) {
            throw new ArithmeticException();
        }

        var result = firstNumber / secondNumber;
        logger.log(Level.INFO, "Успешное деление!");
        arrayList.add("Деление " + firstNumber + " / " + secondNumber + " = " + result);
        return result;
    }

    private static boolean giveQuestion(Scanner scanner) {
        while (true) {
            System.out.print("Хотите выполнить ещё одно деление? (да/нет): ");
            String answer = scanner.nextLine().toLowerCase().trim();

            switch (answer) {
                case "да" -> {
                    return true;
                }
                case "нет" -> {
                    return false;
                }
                default -> System.out.println("Пожалуйста, введите 'да' или 'нет'");
            }
        }
    }
}
