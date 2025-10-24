package school.javacore.collections;

/*
Задача:
Напишите программу, которая выполняет следующие действия:
Создаёт ArrayList<Integer> с числами от 1 до 20.
Использует Iterator для обхода списка и удаления всех нечётных чисел.
После удаления выводит обновлённый список на экран.

Требования:
При удалении элементов необходимо использовать метод remove() итератора.
Попробуйте удалить не при помощи метода remove и проверьте, что случится
Рекомендуется протестировать программу, чтобы убедиться, что список после удаления содержит только чётные числа.
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorsLesson {
    public static  void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            list.add(i+1);
        }

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            Integer next = iterator.next();

            if (next % 2 != 0) {
                iterator.remove();
            }
        }

        System.out.println(list);
    }
}
