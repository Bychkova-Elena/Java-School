package school.javacore.reflection;

import java.lang.reflect.Modifier;
import java.util.Arrays;

/*
Создайте класс Person (или любой класс на ваш выбор) с несколькими полями и методами (например, name, age, sayHello()).
В main-методе:
Получите объект Class для этого класса (используйте один из трёх способов).
Выведите в консоль полное имя класса, его простой вариант имени и список интерфейсов, которые он реализует.
Добавьте вывод модификаторов класса (числом). Если хотите, попробуйте воспользоваться классом Modifier,
чтобы преобразовать это число в читабельный вид.
*/
public class FirstReflectionLesson {
    public static void main(String[] args) {
        Class<?> clazz = Person.class;
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());
        System.out.println(Arrays.toString(clazz.getInterfaces()));
        int modifiers = clazz.getModifiers();

        System.out.println("Модификаторы: " + modifiers);

        System.out.println("Все модификаторы: " + Modifier.toString(modifiers));
    }
}

class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void sayHello() {
        System.out.println("Hello " + name);
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }
}
