package school.javacore.exceptions;

import java.io.*;

/*
Создайте небольшую программу, которая продемонстрирует разницу между checked и unchecked исключениями,
используя стандартные исключения из Java.
Метод с checked исключением. Напишите метод, который читает первую строку из файла
(для простоты можете использовать new File("test.txt") или запросить имя файла у пользователя).
    При работе с файлами может произойти IOException (checked), поэтому вы должны:
    либо обернуть вызов в try-catch блок,
    либо объявить в сигнатуре метода throws IOException.
    Наблюдайте, что компилятор не даст вам игнорировать IOException.
Метод с unchecked исключением. Напишите метод, который «намеренно» пытается получить доступ к несуществующему
элементу массива (например, arr[10] при arr.length = 5).
    Это вызовет ArrayIndexOutOfBoundsException (unchecked).
    Обратите внимание, что компилятор не требует от вас ставить try-catch или throws для этого исключения —
    но вы можете это сделать, если хотите «перехватить» ошибку.
Главный класс (main). В main вызовите оба метода подряд.
    Для метода, который выбрасывает IOException, обязательно либо оберните вызов в try-catch,
    либо пропишите throws IOException в сигнатуре main.
    Для метода с ArrayIndexOutOfBoundsException можете либо вообще ничего не писать и посмотреть,
    как программа «упадёт», либо добавить try-catch, чтобы «поймать» ошибку.
Эксперимент (по желанию):Добавьте общий try-catch блок вида catch (Exception e) или даже catch (Throwable t) в main,
чтобы увидеть, как «перехватится» любое непредвиденное исключение.
    Попробуйте вызвать методы в разных порядках, добавлять/убирать блоки catch и посмотреть,
    какое сообщение об ошибке получит пользователь.
*/
public class ExceptionHierarchyLesson {
    public static void main(String[] args) {
        try {
            checkedExFun();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        uncheckedExFun();
    }

    public static void checkedExFun() throws IOException {
        File file = new File("text.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String firstLine = reader.readLine();
        System.out.println(firstLine);
    }

    public static void uncheckedExFun() {
        int[] arr = new int[5];
        try {
            arr[10] = 10;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }
}
