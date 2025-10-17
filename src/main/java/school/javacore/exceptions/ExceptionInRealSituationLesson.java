package school.javacore.exceptions;

/*
Задание: «Подсчёт слов в файле с защитой от ошибок»
        Напишите программу, которая:
Просит пользователя ввести путь к файлу.
Считывает этот файл и считает, сколько всего слов (разделённых пробелами) в первой строке.
Обработайте следующие ошибки:
FileNotFoundException (если файла нет).
IOException (ошибка чтения).
InputMismatchException (если пользователь вместо строки ввода что-то «сбоит», хотя для пути обычно это не критично,
но представим, что у нас сложный сценарий ввода).
Любые другие, которые вы сочтёте нужными.
Выведите итоговое число слов или сообщение об ошибке.
В любом случае программа должна выводить «Спасибо за использование!»
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionInRealSituationLesson {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите путь к файлу: ");
            String path = scanner.nextLine();

            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line = bufferedReader.readLine();
            String [] arrWords = line.trim().split("\\\\s+");

            System.out.println("Первая строка содержит " + arrWords.length + " слов.");
        } catch (InputMismatchException e) {
            System.out.println("Некорректный ввод!");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        } finally {
            System.out.println("Спасибо за использование!");
        }
    }
}
