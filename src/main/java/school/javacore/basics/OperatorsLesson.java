package school.javacore.basics;

import java.util.Random;

/*
Допустим, у вас есть три оценки студента (целые числа в диапазоне 0..10). Нужно:

- Вычислить средний балл (просто (оценка1 + оценка2 + оценка3) / 3.0 как double).
- Проверить, все ли оценки равны 10 (== 10). Если да, то вывести особое сообщение
"У студента все оценки максимальные!".
- Проверить, есть ли хотя бы одна оценка 2 или ниже. Если да, то вывести сообщение
"Встречается очень низкая оценка!".
- Если средний балл >= 5, вывести "У студента удовлетворительная успеваемость", иначе —
"У студента неудовлетворительная успеваемость".

Попробуйте добавить проверку: лежит ли каждая из оценок в диапазоне 0..10.
Если вдруг одна из оценок меньше 0 или больше 10, вывести "Ошибка: некорректная оценка!".
*/

public class OperatorsLesson {
    public static void main(String[] args) {
        final int MAX_MARK = 10;
        final int LOW_MARK = 2;

        Random random = new Random();

        int firstMark = random.nextInt(11);
        int secondMark = random.nextInt(11);
        int thirdMark = random.nextInt(11);

        System.out.println("firstMark: " + firstMark);
        System.out.println("secondMark: " + secondMark);
        System.out.println("thirdMark: " + thirdMark);

        if (firstMark < 0 || secondMark < 0 || thirdMark < 0 || firstMark > 10 || secondMark > 10 || thirdMark > 10) {
            System.out.println("Ошибка: некорректная оценка!");
        } else {
            if (firstMark == MAX_MARK && secondMark == MAX_MARK && thirdMark == MAX_MARK) {
                System.out.println("У студента все оценки максимальные!");
            } else if (firstMark <= LOW_MARK || secondMark <= LOW_MARK || thirdMark <= LOW_MARK) {
                System.out.println("Встречается очень низкая оценка!");
            }

            double average = (firstMark + secondMark + thirdMark) / 3.0;

            if (average >= 5) {
                System.out.println("У студента удовлетворительная успеваемость");
            } else {
                System.out.println("У студента неудовлетворительная успеваемость");
            }
        }
    }
}
