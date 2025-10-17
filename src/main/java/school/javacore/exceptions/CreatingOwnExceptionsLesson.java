package school.javacore.exceptions;

/*
Задание: «Система бронирования номеров в отеле»
Создайте класс RoomNotAvailableException, который наследуется от RuntimeException.
В конструктор передавайте сообщение, указывающее на номер комнаты.
Напишите класс Hotel с методом bookRoom(int roomNumber), который:
Проверяет, доступен ли номер.
Если номер недоступен, бросает RoomNotAvailableException.
Если доступен, выводит сообщение «Номер забронирован!».
В методе main напишите код, который:
Создаёт объект Hotel.
Пытается забронировать номер, который «уже занят».
Обрабатывает RoomNotAvailableException и выводит понятное сообщение пользователю.

Дополнительно: Если хотите поэкспериментировать, сделайте другое исключение, например InvalidRoomNumberException,
если номер < 1 или > 1000.
Задание займёт примерно 30–60 минут. Убедитесь, что вы протестировали разные случаи: доступный номер, занятой номер,
некорректный номер.
*/

public class CreatingOwnExceptionsLesson {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Dolphin", 20);
        try {
            hotel.bookRoom(1);
        } catch (RoomNotAvailableException | InvalidRoomNumberException e) {
            System.out.println(e.getMessage());
        }

        try {
            hotel.bookRoom(1);
        } catch (RoomNotAvailableException | InvalidRoomNumberException e) {
            System.out.println(e.getMessage());
        }

        try {
            hotel.bookRoom(2);
        } catch (RoomNotAvailableException | InvalidRoomNumberException e) {
            System.out.println(e.getMessage());
        }

        try {
            hotel.bookRoom(21);
        } catch (RoomNotAvailableException | InvalidRoomNumberException e) {
            System.out.println(e.getMessage());
        }

        try {
            hotel.bookRoom(0);
        } catch (RoomNotAvailableException | InvalidRoomNumberException e) {
            System.out.println(e.getMessage());
        }
    }
}

class RoomNotAvailableException extends RuntimeException {
    public RoomNotAvailableException(int roomNumber) {
        super("Room " + roomNumber + " not available");
    }
}

class InvalidRoomNumberException extends RuntimeException {
    public InvalidRoomNumberException() {
        super("Invalid room number!");
    }
}

class Hotel {
    private String name;
    private int capacity;
    private int [] arr;

    public Hotel(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        arr = new int[capacity];
    }

    void bookRoom(int roomNumber) {
        if (roomNumber-1 < 0 || roomNumber > capacity ) {
            throw new InvalidRoomNumberException();
        }
        if (arr[roomNumber-1] == 1) {
            throw new RoomNotAvailableException(roomNumber);
        }

        arr[roomNumber-1] = 1;
        System.out.println("Номер забронирован!");
    }
}
