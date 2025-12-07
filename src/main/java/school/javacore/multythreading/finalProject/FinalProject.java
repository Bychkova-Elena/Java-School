package school.javacore.multythreading.finalProject;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class FinalProject {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        DataProcessor dataProcessor = new DataProcessor(executorService);
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            dataProcessor.calculateSumTask(
                    random.ints(10, 0, 100)
                            .boxed()
                            .collect(Collectors.toList()));
        }

        executorService.shutdown();

        int activeTaskCount = dataProcessor.getActiveTasks();
        while (activeTaskCount > 0) {
            System.out.println("Количество активных задач: " + activeTaskCount);
            Thread.sleep(200);
            activeTaskCount = dataProcessor.getActiveTasks();
        }

        for (int i = 1; i <= 100; i++) {
            String taskName = "task" + i;
            System.out.println(taskName + " result: " + dataProcessor.getResult(taskName).get());
        }
    }
}
