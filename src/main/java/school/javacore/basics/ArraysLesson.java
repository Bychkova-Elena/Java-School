package school.javacore.basics;

/*
Создаёт массив из 10 целых чисел (заполните их случайными значениями или вводом с клавиатуры).
Выводит все элементы массива на экран.
Определяет и выводит индекс минимального и максимального элемента (или сами эти элементы).
Сортирует массив по возрастанию (можно любым способом, например, «пузырьком») и выводит результат.
        (Опционально) Создаёт двумерный массив размером 2×5, заполняет его и выводит на экран в виде таблицы.

        Подсказка: используйте циклы для заполнения и обхода массивов, методы для поиска и сортировки элементов.
*/

import java.util.Arrays;
import java.util.Random;

public class ArraysLesson {
    public static void main(String[] args) {
        Random random = new Random();
        int [] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

        System.out.print("Значения массива: ");
        for (int value : arr) {
            System.out.print(value + " ");
        }

        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }

            if (arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.println("\nМинимальное значение: " + min);
        System.out.println("Максимальное значение: " + max);

        //Сортировка пузырьком
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i - 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    isSorted = false;
                }
            }
        }

        System.out.println("Отсортированный массив: " + Arrays.toString(arr));

        //двумерный массив размером 2×5
        int [][] doubleArr = new int[2][5];
        for (int i = 0; i < doubleArr.length; i++) {
            for (int j = 0; j < doubleArr[i].length; j++) {
                doubleArr[i][j] = random.nextInt(100);
                System.out.print(doubleArr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
