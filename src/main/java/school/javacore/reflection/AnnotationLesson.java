package school.javacore.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/*
Создайте аннотацию @Author, которая будет хранить имя автора и дату написания этого куска метода или класса.
Создайте класс Book с несколькими методами и аннотируйте их этой аннотацией.
Напишите код, который будет выводить имя автора для всех методов, помеченных аннотацией @Author, используя рефлексию.
*/
public class AnnotationLesson {
    public static void main(String[] args) {
        Class<?> clazz = Book.class;

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Author.class)) {
                Author author = method.getAnnotation(Author.class);
                System.out.println(author.name() + " " + author.date());
            }
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Author {
    String name() default "noName";
    String date() default "noDate";
}

class Book {
    @Author(name = "Pushkin", date = "18.11.2025")
    void pushkinMethod() {
        System.out.println("Im Pushkin");
    }

    @Author(name = "Lermontov", date = "18.11.2025")
    void lermontovMethod() {
        System.out.println("Im Lermontov");
    }

    void noAnnotationMethod() {
        System.out.println("Im noAnnotation");
    }
}
