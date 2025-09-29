package school.javacore.basics;

/*
Считывает строку с клавиатуры (например, "Hello, Java World!").
Выводит длину этой строки.
Выводит её в верхнем регистре.
        Проверяет, содержится ли в строке слово "Java". Если да — выводит индекс первого вхождения,
        если нет — пишет, что не найдено.
Делит строку на слова (разделитель — пробел) и выводит все слова по одному в консоль.

Подсказка: используйте Scanner для считывания пользовательского ввода,
методы .contains() или .indexOf() для поиска подстроки и .split(" ") для разбиения на слова.
*/

import java.util.Scanner;

public class StringLesson {
    public static void main(String[] args) {
        System.out.print("Введите строку: ");
        String str = new Scanner(System.in).nextLine();
        System.out.println("Длина строки: " + str.length());
        System.out.println("Строка в верхнем регистре: " + str.toUpperCase());

        int indexStringContainsJava = str.indexOf("Java");
        System.out.println("Индекс первого вхождения слова Java: " +
                (indexStringContainsJava != -1 ? indexStringContainsJava : "Не найдено"));

        System.out.println("Слова предложения: ");
        String [] arrString = str.split(" ");
        for (String s : arrString) {
            System.out.println(s);
        }
    }
}
