package school.javacore.streamapi;

/*
Задача:
Напишите консольное приложение, которое:
Создаёт несколько стримов с использованием различных методов создания
(из коллекции, массива, отдельных элементов, генераторов).
Применяет к созданным стримам одну или две промежуточные операции (например, filter для отбора элементов по условию).
Выводит результат работы с помощью терминальной операции forEach.

Подсказка:
Попробуйте создать стрим чисел, отфильтровать только чётные числа, а затем вывести их.
Сгенерируйте стрим случайных чисел, ограничьте его 10 элементами и выведите результат.
*/

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamApiSecondLesson {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.stream();
        System.out.print("Stream из коллекции: ");
        stream.filter(i -> i % 2 == 0).forEach(integer -> System.out.print(integer + " "));
        System.out.println();

        Integer[] array = {1, 2, 3, 4, 5};
        Stream<Integer> stream2 = Arrays.stream(array);
        System.out.print("Stream из массива: ");
        stream2.filter(i -> i % 2 == 0).forEach(integer -> System.out.print(integer + " "));
        System.out.println();

        Stream<Integer> stream3 = Stream.of(1,2,3,4,5);
        System.out.print("Stream из отдельных элементов: ");
        stream3.filter(i -> i % 2 == 0).forEach(integer -> System.out.print(integer + " "));
        System.out.println();

        Stream<Double> stream4 = Stream.generate(Math::random);
        System.out.print("Stream из генераторов: ");
        stream4.limit(10).forEach(integer -> System.out.print(integer + " "));

    }
}
