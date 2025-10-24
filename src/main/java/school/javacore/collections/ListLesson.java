package school.javacore.collections;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Задание: Напишите программу на Java, которая управляет списком задач (например, список дел). Программа должна:
Создавать список задач с использованием реализации List (попробуйте оба варианта:ArrayList и LinkedList).
Добавлять задачи в список.
Вставлять задачу в определенную позицию в списке.
Удалять задачу по индексу или по значению.
Выводить текущий список задач на экран.

Можно для этого создать отдельный класс. TaskManager с методами работы со списком задач.
*/

public class ListLesson {
    public static  void main(String[] args) {
        TaskManager tasks = new TaskManager();
        tasks.addTask("Помыть посуду");
        tasks.addTask(0, "Погулять с собакой");
        tasks.printTasks();
        tasks.removeTask(0);
        tasks.printTasks();

        System.out.println("\nLinkedList:");
        TaskManager linkedTasks = new TaskManager(true);
        linkedTasks.addTask("Вынести мусор");
        linkedTasks.printTasks();
        linkedTasks.removeTask("Вынести мусор");
        linkedTasks.printTasks();
    }
}

class TaskManager {
    List<String> list;

    public TaskManager() {
        list = new ArrayList<>();
    }

    public TaskManager(boolean isLinkedList) {
        if (isLinkedList) {
            list = new LinkedList<>();
        } else {
            list = new ArrayList<>();
        }
    }

    void addTask(String task) {
        list.add(task);
    }

    void addTask(int index, String task) {
        list.add(index, task);
    }

    void removeTask(String task) {
        list.remove(task);
    }

    void removeTask(int index) {
        list.remove(index);
    }

    void printTasks() {
        System.out.println(list);
    }
}
