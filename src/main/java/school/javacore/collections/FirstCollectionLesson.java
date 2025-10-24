package school.javacore.collections;

/*
Напишите обобщённый класс GenericBox<T>, который:
Имеет приватное поле для хранения объекта типа T;
Содержит конструктор для инициализации этого поля;
Предоставляет методы для установки и получения значения;
Имеет обобщённый метод isEqual(GenericBox<T> other),
который сравнивает содержимое текущей коробки с содержимым другой коробки.

Усложненное задание: на основе задания выше, дополнительно:
Добавьте метод swap(GenericBox<T> other), который меняет содержимое текущей коробки с содержимым другой коробки;
Напишите тестовый класс с методом main, в котором создайте несколько экземпляров GenericBox с различными типами
(например, Integer и String), продемонстрируйте работу методов установки, получения, сравнения и обмена содержимым.
*/

public class FirstCollectionLesson {
    public static void main(String[] args) {
        GenericBox<Integer> box1 = new GenericBox<>(10);
        GenericBox<String> box2 = new GenericBox<>("Hello");

        box2.setT(box2.getT() + ", world");
        System.out.println("Содеоживое box2: " + box2.getT());

        System.out.println("box1 равен new box: " + box1.isEqual(new GenericBox<>(20)));

        GenericBox<String> box3 = new GenericBox<>("Hello, sun");
        box3.swap(box2);
        System.out.println("Содеоживое box2: " + box2.getT()); // Hello, world -> Hello, sun
        System.out.println("Содеоживое box3: " + box3.getT()); // Hello, sun -> Hello, world
    }
}

class GenericBox<T> {
    private T t;

    public GenericBox(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    boolean isEqual(GenericBox<T> other) {
        return this.t.equals(other.getT());
    }

    void swap(GenericBox<T> other) {
        T temp = other.getT();
        other.setT(this.getT());
        this.setT(temp);
    }
}
