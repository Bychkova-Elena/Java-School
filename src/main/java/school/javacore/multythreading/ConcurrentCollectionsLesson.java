package school.javacore.multythreading;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/*
Задание «Синхронизированный чат»
Напишите простой класс ChatRoom, где несколько потоков могут одновременно:
Отправлять сообщения в общий чат (используйте CopyOnWriteArrayList или ConcurrentLinkedQueue для хранения сообщений).
Читать последние N сообщений.

Требования:
Структура класса ChatRoom:
Коллекция для хранения всех сообщений.
Метод postMessage(String user, String text), который добавляет новое сообщение.
Метод getRecentMessages(int count), который возвращает список последних count сообщений.

Основная логика:
Пусть 2-3 «пользователя» (потока) одновременно отправляют сообщения.
Ещё 1-2 потока периодически вызывают getRecentMessages(...), чтобы вывести последние сообщения в консоль.

Цель:
Убедиться, что при параллельном доступе не возникает исключений.
Все сообщения сохраняются и читаются корректно
(пусть в лог выводится, что происходит: “User1 posted …”, “Reading messages …”).

Подсказки:
Для хранения сообщений можно использовать CopyOnWriteArrayList, если предполагается частое чтение и редкая запись.
Если записи тоже много, можно попробовать ConcurrentLinkedQueue, но тогда нужно продумать,
как получать последние count элементов (очередь — структура FIFO, не самый удобный вариант, но можно решить).

Задача:
Реализуйте класс ChatRoom с вышеописанной логикой.
Создайте 3-4 потока, которые по очереди пишут сообщения, и 1 поток — «читатель».
Запускайте их и смотрите вывод в консоль.
При желании, добавьте тест (можно на junit или простой main) с циклом, где будут непрерывно генерироваться сообщения,
а потом проверьте корректность истории сообщений
*/
public class ConcurrentCollectionsLesson {
    public static void main(String[] args) throws InterruptedException {
        ChatRoom chatRoom = new ChatRoom();

        Thread thread = new Thread(() -> {
            chatRoom.postMessage("User1", "Hello!");
        });

        Thread thread2 = new Thread(() -> {
            chatRoom.postMessage("User2", "Where is my key?");
        });

        Thread thread3 = new Thread(() -> {
            chatRoom.postMessage("User3", "I bought a car!");
        });

        Thread thread4 = new Thread(() -> {
            List<String> messages = chatRoom.getRecentMessages(2);
            for (String m : messages) {
                System.out.println(m);
            }
        });

        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread.join();
        thread2.join();
        thread3.join();
        thread4.join();
    }
}

class ChatRoom {
    CopyOnWriteArrayList<String> messageList = new CopyOnWriteArrayList<>();

    public void postMessage(String user, String text) {
        messageList.add(text);
        System.out.println(user + " posted message");
     }

    public List<String> getRecentMessages(int count) {
        System.out.println("Reading messages...");
        int start = Math.max(0, messageList.size() - count);
        return messageList.subList(start, messageList.size());
    }
}
