package school.javacore.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Создайте список чисел от 1 до 20.
С помощью Stream API:
Отфильтруйте только чётные числа.
Примените map, чтобы возвести каждое число в квадрат.
Соберите результат в список и выведите его с помощью forEach.
Попробуйте вызвать терминальную операцию (forEach) дважды на одном стриме,
чтобы увидеть ошибку повторного использования.
(Опционально) Измерьте время выполнения для обычного цикла for и для стрима,
выполняющего те же операции, используя System.nanoTime().

Подсказка:
Используйте collect(Collectors.toList()) для сбора результатов.
Обработайте исключение при повторном использовании стрима.
*/
public class LazyExecutionLesson {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        long startTime = System.nanoTime();
        Stream<Integer> stream = list.stream();
        stream
                .filter(i -> i % 2 == 0)
                .map(i -> i * 2)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        long endTime = System.nanoTime();

        System.out.println("Stream time: " + (endTime - startTime));

        long start2Time = System.nanoTime();
        List<Integer> forList = new ArrayList<>();
        for (Integer i : list) {
            if (i % 2 == 0) {
                forList.add(i * 2);
                System.out.println(forList.get(forList.size() - 1));
            }
        }
        long end2Time = System.nanoTime();
        System.out.println("For time: " + (end2Time - start2Time));

        try {
            stream.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
