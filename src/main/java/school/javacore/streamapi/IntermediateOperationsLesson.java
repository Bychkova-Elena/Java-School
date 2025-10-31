package school.javacore.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
Напишите программу, которая:
1. Создаёт список строк, где каждая строка представляет предложение
(например, “Java is fun”, “Stream API simplifies data processing”).
2. С помощью flatMap разбивает каждое предложение на отдельные слова и объединяет их в один стрим.
3. Применяет filter, чтобы оставить только слова длиной более 3 символов.
4. Применяет distinct для удаления дубликатов.
5. Сортирует полученные слова в алфавитном порядке.
6. Выводит итоговый список слов через forEach.
*/

public class IntermediateOperationsLesson {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("java is fun", "stream API simplifies data processing", "java is fun");

        Stream<String> stream = list.stream();
        stream
                .flatMap((s) -> Arrays.stream(s.split(" ")))
                .filter((s) -> s.length() > 3)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }
}
