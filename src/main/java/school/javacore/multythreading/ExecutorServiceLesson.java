package school.javacore.multythreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/*
Задача: Написать простую программу, которая:
Создаёт пул потоков с фиксированным количеством (3 потока).
Запускает 5 задач (пускай каждая «спит» разное время, например 1–3 секунды), используя разные методы (execute() и submit()).

Для задач, запущенных через submit(Callable), выводит результат. Для простоты, каждая задача может возвращать строку с текстом «Задача №N завершилась».
Одна из задач должна «спать» особенно долго (8 секунд). Попробуйте дождаться её результат в течение 3 секунд через get(3,TimeUnit.SECONDS), и если не успеет, отмените её.
В конце выведите информацию о том, какие задачи успешно выполнились, а какие были отменены.

Подсказки:
Используйте isCancelled() или isDone() для проверки состояния задач.
Поэкспериментируйте с newCachedThreadPool() и сравните поведение.
*/
public class ExecutorServiceLesson {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future> futures = new ArrayList<>();

        for (int i = 1; i <= 2; i++) {
            int finalI = i;
            executor.execute(() -> {
                try {
                    Thread.sleep(finalI * 1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Задача " + finalI + " завершилась");
            });
        }

        for (int i = 3; i <= 5; i++) {
            int finalI = i;
            Future<String> featureResult = executor.submit(() -> {
                try {
                    Thread.sleep(finalI * 2000);
                    return "Задача " + finalI + " завершилась";
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            futures.add(featureResult);
        }

        for (Future f : futures) {
            try {
                System.out.println(f.get(6000, TimeUnit.MILLISECONDS));
            } catch (TimeoutException e) {
                f.cancel(true);
            } finally {
                executor.shutdown();

                if (f.isCancelled()) {
                    System.out.println("1 задача была отменена");
                }
            }
        }
    }
}
