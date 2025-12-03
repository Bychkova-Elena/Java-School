package school.javacore.multythreading;

import java.util.concurrent.CompletableFuture;

/*
Задача: Реализовать «цепочку» на основе CompletableFuture, чтобы закрепить основные методы.
Долгая вычислительная операция: напишите CompletableFuture.supplyAsync(...),
который будет, например, «считать факториал» или «делать сложный расчёт»
(можете просто Thread.sleep(...), чтобы симулировать задержку).
Преобразование результата: через thenApply(...) или thenCompose(...) добавьте ещё одну асинхронную операцию
(например, умножьте полученный факториал на какое-то число).
Возможная ошибка: вставьте код, который может выбросить исключение (например, если число > определённого порога).
Обработайте это исключение через exceptionally(...).
Вывод результата: используйте thenAccept(...), чтобы вывести результат в консоль, не вызывая get().

(Дополнительно): хотите больше практики? Реализуйте параллельно две независимые вычислительные задачи
(например, две разные формулы), а затем объедините результаты в одной цепочке с помощью thenCombine(...).
*/
public class CompletableFutureLesson {
    private final static int MAX_VALUE = 10;

    public static void main(String[] args) {
        CompletableFuture<Integer> value = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return 10;
        })
          .thenApply((val) -> val * 2)
          .thenCompose((val) -> {
            if (val > MAX_VALUE) {
                throw new RuntimeException("Too big value");
            }

            return CompletableFuture.supplyAsync(() -> val * 2);
        })
          .exceptionally(ex -> {
              System.out.println(ex.getMessage());
              return null;
        });

        value.thenAccept((val) -> System.out.println("Final value: " + val));


        // thenCombine
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return 2;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return 5;
        });

        future1.thenCombine(future2, Integer::sum).thenAccept(System.out::println);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
