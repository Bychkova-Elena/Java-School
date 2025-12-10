package school.javacore.multythreading.finalProject;

import java.util.List;
import java.util.concurrent.Callable;

public class CalculateSumTask implements Callable<Integer> {
    private final List<Integer> numbers;
    private final String task;

    public CalculateSumTask(List<Integer> numbers, String task) {
        this.numbers = numbers;
        this.task = task;
    }

    @Override
    public Integer call() {
        System.out.println("Имя задачи: " + task);
        System.out.println("Имя потока: " + Thread.currentThread().getName());

        int sum = numbers.stream().reduce(0, Integer::sum);

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return sum;
    }
}
