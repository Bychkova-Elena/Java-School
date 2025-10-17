package school.javacore.exceptions;

/*
Задание: Напишите программу, которая запрашивает у пользователя два числа и делит первое на второе.
Если второе число равно нулю, программа должна перехватить исключение и вывести понятное сообщение об ошибке.
В любом случае, после попытки деления нужно вывести сообщение «Спасибо за использование программы».
*/

import java.util.Scanner;

public class FirstExceptionsLesson {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int a = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int b = scanner.nextInt();

        try {
            int c = a / b;
            System.out.println("Результат: " + c);
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль! Пожалуйста, попробуйте другое число");
        } finally {
            System.out.println("Спасибо за использование программы");
        }
    }
}
