package school.javacore.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
Создайте простой класс Student с приватными полями name, age и публичным полем university.
В этом классе сделайте один публичный конструктор и один приватный
(например, приватный без параметров, публичный — с параметрами).
Также добавьте пару методов (например, публичный introduce() и приватный studySecretly()).

Напишите основную программу (метод main), где при помощи рефлексии вы:
Получите и вызовете приватный конструктор, чтобы создать объект.
Выведите список всех полей (включая приватные).
Считайте поле name и задайте ему новое значение — всё через рефлексию.
Найдите и вызовите приватный метод studySecretly().
Убедитесь, что всё работает: например, распечатайте значения в консоль, чтобы увидеть результат.
*/
public class ReflectionsMethodLesson {
    public static void main(String[] args) {
        Class<?> clazz = Student.class;

        try {
            Constructor<?> privateConstructor = clazz.getDeclaredConstructor();
            privateConstructor.setAccessible(true);
            Student privateObject = (Student) privateConstructor.newInstance();
            privateObject.introduce();

            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                System.out.println(field.getName());
            }

            Field nameField = clazz.getDeclaredField("name");
            nameField.setAccessible(true);
            nameField.set(privateObject, "Lena");
            System.out.println(nameField.get(privateObject));
            nameField.setAccessible(false);

            Method studySecretlyMethod = clazz.getDeclaredMethod("studySecretly");
            studySecretlyMethod.setAccessible(true);
            studySecretlyMethod.invoke(privateObject);
            studySecretlyMethod.setAccessible(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Student {
    private String name;
    private int age;
    public String university;

    private Student() {}

    public Student(String name, int age, String university) {
        this.name = name;
        this.age = age;
        this.university = university;
    }

    public void introduce() {
        System.out.println("Hello, " + name + ", " + age + ", " + university);
    }

    private void studySecretly() {
        System.out.println("Studying...");
    }
}
