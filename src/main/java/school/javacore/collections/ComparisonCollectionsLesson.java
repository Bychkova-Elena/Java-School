package school.javacore.collections;

/*
Задача: Вам дан следующий код, который использует ArrayList для проверки наличия дубликатов в списке целых чисел.
Оптимизируйте этот код, заменив используемую коллекцию так, чтобы проверить наличие дубликатов за меньшее время.
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComparisonCollectionsLesson {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <= 100000; i++) {
            numbers.add(i);
        }

        numbers.add(50000);

        Long startTime = System.currentTimeMillis();
        boolean hasDuplicates = false;
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i).equals(numbers.get(j))) {
                    hasDuplicates = true;
                    break;
                }
            }
            if (hasDuplicates) break;
        }

        Long endTime = System.currentTimeMillis();
        System.out.println("Дубликаты найдены: " + hasDuplicates
                + " Потраченное время: " + (endTime - startTime) + "ms"); // 4402ms


        // Использую HashSet
        Long startTime2 = System.currentTimeMillis();

        Set<Integer> set = new HashSet<>(numbers);
        boolean hasDuplicates2 = set.size() != numbers.size();

        Long endTime2 = System.currentTimeMillis();
        System.out.println("Дубликаты найдены: " + hasDuplicates2
                + " Потраченное время: " + (endTime2 - startTime2) + "ms"); // 5ms
    }
}
