package school.javacore.streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Задача:
Создайте класс User с полями: String name и int age.
Создайте список пользователей с различными именами и возрастами
(не менее 5–7 объектов, включите несколько повторяющихся имен или значений).
Используя Stream API:
Отфильтруйте пользователей, чей возраст больше 25 лет.
Извлеките их имена с помощью map.
Отсортируйте имена в алфавитном порядке.
Удалите дубликаты с помощью distinct.
Соберите результат в список и выведите его.

Дополнительно, с использованием reduce:
Вычислите общую сумму возрастов пользователей.
Найдите минимальный возраст среди всех пользователей.
(Опционально) Если хотите, попробуйте сгенерировать стрим с помощью Stream.of или Arrays.stream для другой задачи,
например, для работы со строками.

Подсказка:
Используйте метод collect(Collectors.toList()) для сбора результата.
Для reduce можете использовать вариант с начальным значением (например, 0 для суммы) или без него,
работая с объектом Optional.
*/

public class TerminalOperationsLesson {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Lena", 20),
                new User("Dina", 25),
                new User("Sveta", 50),
                new User("Nastya", 30),
                new User("Lena", 20),
                new User("Ira", 25),
                new User("Ira", 30)
        );

        Stream<User> userStream = users.stream();
        List<String> namesList = userStream
                .filter((user) -> user.getAge() > 25)
                .map(User::getName)
                .sorted()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(namesList);

        Stream<User> userStream2 = users.stream();
        int ageSum = userStream2.reduce(0, (acc, user) -> acc + user.getAge(), Integer::sum);
        System.out.println("Общая сумма возрастов пользователей: " + ageSum);

        Stream<User> userStream3 = users.stream();
        int minAge = userStream3.min(Comparator.comparingInt(User::getAge)).map(User::getAge).orElse(-1);
        System.out.println("Минимальный возраст среди всех пользователей: " + minAge);

    }
}

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
