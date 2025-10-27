package school.javacore.collections.project;

import javax.naming.NameAlreadyBoundException;
import java.util.*;

public class CollectionsProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Contact> contacts = new ArrayList<>();
        Set<Contact> contactSet = new HashSet<>();
        Set<String> nameSet = new HashSet<>();
        Map<String, List<Contact>> contactMap = new HashMap<>();

        while (true) {
            int input = showMenuAndGetInput(scanner);
            switch (input) {
                case 1 -> addContact(scanner, contacts, contactSet, nameSet, contactMap);
                case 2 -> deleteContact(scanner, contacts, contactSet, contactMap);
                case 3 -> showContacts(contacts);
                case 4 -> searchContact(scanner, contacts);
                case 5 -> showContactsByGroup(scanner, contactMap);
                case 0 -> {
                    return;
                }
                default -> System.out.println("Доступные цифры для ввода: 1, 2, 3, 4, 5, 0");
            }
        }
    }

    private static int showMenuAndGetInput(Scanner scanner) {
        System.out.println("«1»: Добавить контакт");
        System.out.println("«2»: Удалить контакт");
        System.out.println("«3»: Посмотреть все контакты");
        System.out.println("«4»: Найти контакт");
        System.out.println("«5»: Посмотреть контакты по группе");
        System.out.println("«0»: Выход");

        try {
            System.out.print("Выберите пункт, введите только цифру: ");
            int input = scanner.nextInt();
            scanner.nextLine();
            return input;
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: Введена не цифра");
            scanner.nextLine();
        }
        return -1;
    }

    private static void addContact(Scanner scanner,
                                   List<Contact> contacts,
                                   Set<Contact> contactSet,
                                   Set<String> nameSet,
                                   Map<String, List<Contact>> contactMap) {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите телефон: ");
        String phone = scanner.nextLine();
        System.out.print("Введите email: ");
        String email = scanner.nextLine();
        System.out.print("Введите группу: ");
        String group = scanner.nextLine();

        Contact newContact = new Contact(name, phone, email, group);
        int contactSize = contactSet.size();
        contactSet.add(newContact);
        nameSet.add(name);

        try {
            if (contactSize != contactSet.size() && contactSize != nameSet.size()) {
                contacts.add(newContact);

                addContactInMap(contactMap, group, newContact);

                System.out.println("Контакт добавлен!");
            } else if (contactSize == nameSet.size()) {
                throw new NameAlreadyBoundException("Контакт с таким именем уже существует!");
            } else {

                Iterator<Contact> iterator = contacts.iterator();
                Contact deletedContact = null;

                while (iterator.hasNext()) {
                    Contact contact = iterator.next();
                    if (contact.getPhone().equals(phone)) {
                        deletedContact = contact;
                        iterator.remove();
                    }
                }

                assert deletedContact != null;
                List<Contact> contactList = contactMap.get(deletedContact.getGroup());
                Iterator<Contact> iteratorMap = contactList.iterator();

                while (iteratorMap.hasNext()) {
                    Contact contact = iteratorMap.next();
                    if (contact.getPhone().equals(phone)) {
                        iteratorMap.remove();
                    }
                }

                contacts.add(newContact);
                addContactInMap(contactMap, group, newContact);
                System.out.println("Контакт изменен!");
            }
        } catch (NameAlreadyBoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteContact(Scanner scanner,
                                      List<Contact> contacts,
                                      Set<Contact> contactSet,
                                      Map<String, List<Contact>> contactMap) {
        System.out.print("Введите имя контакта для удаления: ");
        String name = scanner.nextLine();
        boolean found = false;

        try {
            Iterator<Contact> iterator = contacts.iterator();

            while (iterator.hasNext()) {
                Contact contact = iterator.next();
                if (contact.getName().equals(name)) {
                    iterator.remove();
                    contactSet.remove(contact);
                    contactMap.get(contact.getGroup()).remove(contact);
                    found = true;

                    System.out.println("Контакт удален!");
                }
            }

            if (!found) {
                throw new NoSuchElementException("Контакт не найден!");
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void showContacts(List<Contact> contacts) {
        Iterator<Contact> iterator = contacts.iterator();

        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            System.out.println(contact);
        }

        if (contacts.isEmpty()) {
            System.out.println("Пусто!");
        }
    }

    private static void searchContact(Scanner scanner, List<Contact> contacts) {
        System.out.print("Введите имя контакта для поиска: ");
        String name = scanner.nextLine();
        boolean found = false;

        try {
            Iterator<Contact> iterator = contacts.iterator();

            while (iterator.hasNext()) {
                Contact contact = iterator.next();
                if (contact.getName().equals(name)) {
                    System.out.println(contact);
                    found = true;
                }
            }
            if (!found) {
                throw new NoSuchElementException("Контакт не найден!");
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void showContactsByGroup(Scanner scanner, Map<String, List<Contact>> contactMap) {
        System.out.print("Введите название группы: ");
        String group = scanner.nextLine();

        System.out.println("\n --- Контакты в группе \"" + group + "\": ---");

        List<Contact> contactsList = contactMap.get(group);

        if (contactsList.isEmpty()) {
            System.out.println("Нет контактов!");
        }

        try {
            Iterator<Contact> iterator = contactsList.iterator();
            while (iterator.hasNext()) {
                Contact contact = iterator.next();
                System.out.println(contact);
            }
        } catch (NullPointerException e) {
            System.out.println("Нет контактов!");
        }
    }

    private static void addContactInMap(Map<String, List<Contact>> contactMap, String group, Contact newContact) {
        if (contactMap.containsKey(group)) {
            contactMap.get(group).add(newContact);
        } else {
            List<Contact> contactList = new ArrayList<>();
            contactList.add(newContact);
            contactMap.put(group, contactList);
        }
    }
}
