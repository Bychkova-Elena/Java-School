package school.javacore.exceptions.project;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ExceptionsProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            int input = showMenuAndGetInput(scanner);
            switch (input) {
                case 1 -> showAllBooks(library.getAllBooks());
                case 2 -> addBookInLibrary(scanner, library);
                case 3 -> takeBookInLibrary(scanner, library);
                case 4 -> returnBookInLibrary(scanner, library);
                case 5 -> {
                    return;
                }
                default -> System.out.println("Доступные цифры для ввода: 1, 2, 3, 4, 5");
            }
        }
    }

    private static int showMenuAndGetInput(Scanner scanner) {
        System.out.println("1. Вывести каталог.");
        System.out.println("2. Добавить объект.");
        System.out.println("3. Выдать объект.");
        System.out.println("4. Вернуть объект.");
        System.out.println("5. Выйти из приложения.");

        try {
            System.out.print("Выберите пункт, введите только цифру: ");
            int input = scanner.nextInt();
            scanner.nextLine();
            return input;
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: Введена не цифра");
            scanner.nextLine();
        }
        return 0;
    }

    private static void showAllBooks(List<Book> catalog) {
        System.out.println("Количество книг в каталоге: " + catalog.size());
        for (Book book : catalog) {
            System.out.println(book);
        }
    }

    private static void addBookInLibrary(Scanner scanner, Library library) {
        try {
            System.out.print("Введите title: ");
            String title = scanner.nextLine();
            System.out.print("Введите author: ");
            String author = scanner.nextLine();
            System.out.print("Введите copies: ");
            int copies = scanner.nextInt();
            library.addBook(title, author, copies);
            System.out.println("Книга добавлена!");
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void takeBookInLibrary(Scanner scanner, Library library) {
        System.out.print("Введите title: ");
        String title = scanner.nextLine();

        try {
            library.takeBook(title);
            System.out.println("Книга выдана!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void returnBookInLibrary(Scanner scanner, Library library) {
        System.out.print("Введите title: ");
        String title = scanner.nextLine();

        try {
            library.returnBook(title);
            System.out.println("Книга возвращена!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
