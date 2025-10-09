package school.javacore.oop;

/*
Задача:
Создайте класс Book с полями title (название) и author (автор).
Переопределите в классе Book методы toString(), equals() и hashCode() так, чтобы два объекта считались равными,
если их title и author совпадают.
Напишите класс Library, где в методе main создайте несколько объектов Book, сравните их между собой с помощью equals(),
выведите их строковое представление через toString() и продемонстрируйте корректность работы переопределённых методов.
*/

import java.util.Objects;

public class ObjectLesson {
    public static void main(String[] args) {
        ObjectLessonBook book1 = new ObjectLessonBook("Book1", "Author1");
        ObjectLessonBook book2 = new ObjectLessonBook("Book2", "Author2");
        ObjectLessonBook book3 = new ObjectLessonBook("Book1", "Author1");

        System.out.println(book1.toString());
        System.out.println(book2.toString());
        System.out.println(book3.toString());

        System.out.println(book1.equals(book2));
        System.out.println(book1.equals(book3));

        System.out.println(book1.hashCode());
        System.out.println(book2.hashCode());
        System.out.println(book3.hashCode());
    }
}

class ObjectLessonBook {
    String title;
    String author;

    public ObjectLessonBook(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectLessonBook that = (ObjectLessonBook) o;
        return Objects.equals(title, that.title) && Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    @Override
    public String toString() {
        return "ObjectLessonBook{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
