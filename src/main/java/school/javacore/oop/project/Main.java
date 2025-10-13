package school.javacore.oop.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        boolean isExit = false;

        while (!isExit) {
            System.out.println("Добро пожаловать в консольное меню!");
            System.out.println("Bы можете:");
            System.out.println("Опция 1: Добавить новую публикацию.");
            System.out.println("Опция 2: Вывести список всех публикаций.");
            System.out.println("Опция 3: Поиск публикации по автору.");
            System.out.println("Опция 4: Вывести общее количество публикаций");
            System.out.println("Опция 0: Выход.");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    Publication pub = null;
                    System.out.println("Выберите тип публикации: 1 – Book, 2 – Magazine, 3 – Newspaper");
                    String type = scanner.nextLine();

                    if (!type.equals("1") && !type.equals("2") && !type.equals("3")) {
                        System.out.println("Нет такого типа публикации");
                    } else {
                        System.out.print("Введите название: ");
                        String title = scanner.nextLine();
                        System.out.print("Введите автора: ");
                        String author = scanner.nextLine();
                        System.out.print("Введите год: ");
                        int year = scanner.nextInt();
                        scanner.nextLine();

                        switch (type) {
                            case "1":
                                System.out.print("Введите ISBN: ");
                                String ISBN = scanner.nextLine();
                                pub = new Book(title, author, year, ISBN);
                                break;
                            case "2":
                                System.out.print("Введите issueNumber: ");
                                int issueNumber = scanner.nextInt();
                                scanner.nextLine();
                                pub = new Magazine(title, author, year, issueNumber);
                                break;
                            case "3":
                                System.out.print("Введите publicationDay: ");
                                String publicationDay = scanner.nextLine();
                                pub = new Newspaper(title, author, year, publicationDay);
                                break;
                        }

                        library.addPublication(pub);
                        System.out.println("Публикация добавлена\n");
                    }

                    break;
                case "2":
                    library.listPublications();
                    break;
                case "3":
                    System.out.print("Введите автора: ");
                    String searchAuthor = scanner.nextLine();
                    library.searchByAuthor(searchAuthor);
                    break;
                case "4":
                    System.out.print("Общее количество публикаций: ");
                    System.out.println(Publication.getPublicationCount());
                    break;
                case "0":
                    isExit = true;
                    break;
                default:
                    System.out.println("Нет такой опции");;
            }
        }
    }
}
