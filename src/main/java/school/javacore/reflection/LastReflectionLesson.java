package school.javacore.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/*
Создайте класс с несколькими полями, помеченными аннотациями @NotNull и @Size.
Напишите метод, который будет проверять эти поля с помощью Reflection, аналогично примеру из урока.
Проверьте, что произойдет, если значения этих полей не соответствуют ограничениям.
*/
public class LastReflectionLesson {
    public static void main(String[] args) {
        User user = new User("J");

        try {
            validate(user);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    static void validate(User user) throws IllegalAccessException {
        Field[] fields = user.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);

            if (field.isAnnotationPresent(NotNull.class)) {
                if (field.get(user) == null) {
                    System.out.println("Field " + field.getName() + " cannot be null!");
                    continue;
                }
            }

            if (field.isAnnotationPresent(Size.class)) {
                Size size = field.getAnnotation(Size.class);
                String value = (String) field.get(user);

                if (value.length() < size.min() || value.length() > size.max()) {
                    System.out.println("Field " + field.getName() + " must be between " + size.min() + " and "
                            + size.max() + " characters!");
                }
            }
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotNull{}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Size{
    int min() default 0;
    int max() default Integer.MAX_VALUE;
}

class User {
    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    public User(String name) {
        this.name = name;
    }
}
