package school.javacore.collections;

/*
Цель задания: Научиться видеть последствия неправильного переопределения методов equals и hashCode
при использовании объектов в качестве ключей в коллекции HashMap. Вы продемонстрируете,
как заведомо неверная реализация приводит к тому, что данные «теряются» или перезаписываются.

Задание:
Создайте класс Product:
Напишите класс Product с несколькими полями, например:
int id
String name
double price
Намеренно реализуйте методы equals и hashCode неправильно:
Метод equals: Реализуйте его так, чтобы сравнивались только, например, поле id,
игнорируя остальные важные поля (name и price).
Метод hashCode: Реализуйте его так, чтобы он всегда возвращал одно и то же значение
(например, всегда возвращал число 42) или не учитывал все значимые поля объекта.
Используйте Product в качестве ключей в HashMap:
Создайте объект типа HashMap<Product, String> и добавьте в него несколько объектов класса Product
с разными значениями полей name и price, но с одинаковым id или с разными id, чтобы проверить, как ведёт себя коллекция.
Анализ результатов:
        Обратите внимание, что если два объекта имеют одинаковый id, то их метод equals вернёт true,
        даже если остальные поля различаются
        При этом константный hashCode приводит к тому, что все объекты попадают в один бакет,
        и при добавлении нового объекта с тем же id старое значение будет перезаписано.
        В результате, даже если вы добавляете несколько продуктов, ожидаемый размер карты может оказаться меньше,
        чем количество вызовов put, или данные окажутся «потеряны».
*/

import java.util.HashMap;
import java.util.Map;

public class EqualsAndHashCodeLesson {
    public static void main(String[] args) {
        Map<Product, String> map = new HashMap<>();

        Product product1 = new Product(0, "Pepsi", 50.00);
        Product product2 = new Product(0, "Cola", 60.00);
        Product product3 = new Product(1, "Water", 80.00);

        System.out.println(product1.equals(product2));

        map.put(product1, "Pepsi");
        map.put(product2, "Cola");
        map.put(product3, "Water");

        for (Map.Entry<Product, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }
    }
}

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return 42;
    }
}
