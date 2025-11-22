package school.javacore.multythreading;

/*
Создайте общую переменную без синхронизированного доступа (например просто Integer, или написать свою обертку для int)
Создайте 4 потока, каждый из которых будет создан разными способами
(используйте разные подходы для создания потоков, описанные в уроке).
Каждый поток должен в цикле 100 раз увеличить значение общей переменной на 1.
Запустите все 4 потока и дождитесь их завершения (например, с помощью метода join()).
Выведите итоговое значение общей переменной — оно очень вероятно не должно быть равно 400.
*/
public class FirstMultythreadingLesson {
    private static Integer j = 0;
    public static void main (String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    j++;
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                j++;
            }
        });

        Runnable runnable = () -> {
            for (int i = 0; i < 100; i++) {
                j++;
            }
        };

        Thread thread3 = new Thread(runnable);

        Thread thread4 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    j++;
                }
            }
        };

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        System.out.println(j);

    }
}
