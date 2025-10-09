package school.javacore.oop;

/*
Создайте класс Main с методом main.
Объявите в методе несколько примитивных переменных (например, int, double, boolean). Выведите их в консоль.
Создайте объект вашего собственного класса (например, Person или Car) и присвойте ссылку локальной переменной.
Выведите поля объекта.
Присвойте переменной null. Проверьте, что дальнейший доступ к объекту теперь невозможен.
        (Опционально) Вызовите System.gc() и посмотрите, будет ли в консоли какое-то сообщение о сборке мусора
        (возможно, не будет, так как это поведение зависит от конкретной JVM и её настроек).
Для наглядности можно добавить finalize() метод в свой класс, который выводит сообщение
(но учтите, что finalize() устарел и не гарантируется к немедленному вызову — лучше воспринимать это как эксперимент).

Что проверить:
Убедитесь, что при присвоении null объект становится недостижим.
Разберитесь, что значит «копирование значения» для примитива и «копирование ссылки» для объектного типа
(напишите метод, который пытается «изменить» ваш объект, и метод, который пытается изменить примитив).
*/

import java.util.Optional;

public class TypesLesson {
    public static void main(String[] args) {
        int intValue = 10;
        double doubleValue = 20.0;
        boolean booleanValue = true;

        System.out.println("intValue = " + intValue);
        System.out.println("doubleValue = " + doubleValue);
        System.out.println("booleanValue = " + booleanValue);

        Person person = new Person("Lena");
        Person person2 = new Person("Kris");

        System.out.println("Persons name = " + person.name);

        person = null;

        //System.out.println("Persons name = " + person.name);

        changePrimitiveType(intValue);
        System.out.println("intValue = " + intValue); // 10

        changeLinkType(person2);
        System.out.println(person2.name); // Olga
    }

    static void changePrimitiveType (int value) {
        value = 100;
    }

    static void changeLinkType (Person person) {
       person.name = "Olga";
    }

}

class Person {
    String name;

    Person (String name) {
        this.name = name;
    }
}
