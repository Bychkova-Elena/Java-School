package school.javacore.basics;

import java.util.Scanner;

public class BasicsFinalProject {
    public static void main(String[] args) {
        int MAX_SIZE_ARRAY = 10;
        Scanner scanner = new Scanner(System.in);
        String [][] contactArr = new String [MAX_SIZE_ARRAY][2];
        int arrSize = 0;
        boolean isExit = false;

        System.out.println("Добро пожаловать в Систему Учета Контактов!\n");
        System.out.println("Выберите пункт меню:");
        System.out.println("1. Добавить контакт");
        System.out.println("2. Просмотреть контакты");
        System.out.println("3. Найти контакт");
        System.out.println("4. Удалить контакт");
        System.out.println("5. Выйти");

        while (!isExit) {
            System.out.println("\nЧто вам надобно сделать?");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    //добавление
                    if (arrSize == MAX_SIZE_ARRAY) {
                        System.out.println("Система контактов заполнена");
                    } else {
                        boolean isNameCorrect = false;
                        String name = "";
                        while (!isNameCorrect) {
                            System.out.print("Имя: ");
                            name = scanner.nextLine().trim();
                            isNameCorrect = true;
                            if (name.isEmpty()) {
                                System.out.println("Нельзя ввести пустое имя");
                                isNameCorrect = false;
                            }

                            for (String [] arr : contactArr) {
                                if (name.equals(arr[0])) {
                                    System.out.println("Такое имя уже существует");
                                    isNameCorrect = false;
                                }
                            }
                        }
                        contactArr[arrSize][0] = name;
                        System.out.print("Телефон: ");
                        contactArr[arrSize][1] = scanner.nextLine();
                        arrSize++;
                        System.out.println("Контакт записан!");
                    }

                    break;

                case "2":
                    //просмотр
                    if (arrSize == 0) {
                        System.out.println("Пусто");
                    } else {
                        for (String[] contact : contactArr) {
                            if (contact[0] != null && contact[1] != null) {
                                System.out.println(contact[0] + " - " + contact[1]);
                            }
                        }
                    }
                    break;

                case "3":
                    //поиск контакта по имени
                    System.out.print("Имя для поиска: ");
                    String name = scanner.nextLine();
                    boolean nameIsExist = false;
                    for (String[] contact : contactArr) {
                        if (contact[0] != null && contact[0].equals(name)) {
                            nameIsExist = true;
                            System.out.printf("Телефон %s: %s", contact[0], contact[1]);
                        }
                    }
                    if (!nameIsExist) {
                        System.out.println("Контакт с именем " + name + " не найден");
                    }
                    break;

                case "4":
                    //удаление контакта
                    System.out.print("Имя для удаления: ");
                    String delName = scanner.nextLine();
                    int contactIndex = -1;
                    for (int i = 0; i < contactArr.length; i++) {
                        if (contactArr[i][0] != null && contactArr[i][0].equals(delName)) {
                            contactIndex = i;
                        }

                        if (contactIndex != -1) {
                            if (i == MAX_SIZE_ARRAY - 1) {
                                contactArr[i][0] = null;
                                contactArr[i][1] = null;
                            } else {
                                contactArr[i][0] = contactArr[i + 1][0];
                                contactArr[i][1] = contactArr[i + 1][1];
                                contactArr[i + 1][0] = null;
                                contactArr[i + 1][1] = null;
                            }
                        }
                    }
                    if (contactIndex == -1) {
                        System.out.println("Контакт с именем " + delName + " не найден");
                    } else {
                        arrSize--;
                        System.out.println("Контакт " + delName + " удален!");
                    }
                    break;

                case "5":
                    //Выход
                    System.out.println("До свидания!");
                    isExit = true;
                    break;

                default:
                    System.out.println("Не знаю такой команды");
            }
        }
    }
}
