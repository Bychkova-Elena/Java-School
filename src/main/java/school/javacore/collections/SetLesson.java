package school.javacore.collections;

import java.util.*;

/*
Задача: Напишите программу, которая удаляет дубликаты из списка строк.

Требования:
Создайте список (например, ArrayList) с повторяющимися элементами.
Используйте HashSet для удаления дубликатов.
Выведите исходный список, затем результат преобразования в Set, а после – итоговый список без дубликатов.
Добавьте комментарии в код, поясняющие каждый шаг.
Используйте потом LinkedHashSet вместо HashSet и сравните порядок элементов в итоговом списке.

Подсказка: Помните, что конструктор HashSet может принять коллекцию, что позволит сразу преобразовать список в множество без дубликатов.
*/

public class SetLesson {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("d", "b", "c", "d")); // создание ArrayList

        Set<String> set = new HashSet<>(list); // удаление дубликатов с помощью HashSet
        Set<String> linkedSet = new LinkedHashSet<>(list); // // удаление дубликатов с помощью LinkedHashSet
        System.out.println(list); // вывод ArrayList
        System.out.println(set); // вывод HashSet
        System.out.println(linkedSet); // вывод linkedSet
    }
}
