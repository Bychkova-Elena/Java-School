package school.javacore.collections;

/*
Задача:
Создайте объект HashMap<String, Integer>, где:
Ключ — название фрукта (например, "Яблоко", "Банан", "Апельсин").
Значение — его цена (целое число).
Добавьте пары "фрукт – цена" в HashMap с помощью метода put().
Выведите начальное содержимое HashMap на экран.
Для этого переберите пары «ключ-значение» с помощью цикла for-each по entrySet().
Обновите цену одного из фруктов (например, измените цену "Банан" с 80 на 90) и снова выведите содержимое Map.
Удалите пару по ключу (например, удалите "Апельсин") и снова выведите содержимое HashMap.
*/

import java.util.HashMap;
import java.util.Map;

public class MapLesson {
    public static void main(String[] args) {
        Map<String, Integer> productsMap = new HashMap<>();

        productsMap.put("Apple", 110);
        productsMap.put("Banana", 60);
        productsMap.put("Orange", 80);

        printProductMap(productsMap);

        productsMap.put("Banana", 70);

        printProductMap(productsMap);

        productsMap.remove("Orange");

        printProductMap(productsMap);
    }

    static void printProductMap(Map<String, Integer> productMap) {
        for (Map.Entry<String, Integer> entry : productMap.entrySet()) {
            System.out.println("Product:" + entry.getKey() + ", price: " + entry.getValue());
        }
        System.out.println();
    }
}
