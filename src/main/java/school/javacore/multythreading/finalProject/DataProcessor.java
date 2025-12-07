package school.javacore.multythreading.finalProject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class DataProcessor {
    private static final AtomicInteger atomicCounter = new AtomicInteger(0);
    private static final AtomicInteger atomicActiveTaskCounter = new AtomicInteger(0);
    private static final Map<String, Integer> results = new HashMap<>();
    private final ExecutorService executorService;

    public DataProcessor(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public void calculateSumTask(List<Integer> numbers) {
        String taskName = "task" + atomicCounter.incrementAndGet();

        CompletableFuture<Integer> future =
                CompletableFuture.supplyAsync(() -> new CalculateSumTask(numbers, taskName).call(), executorService);

        atomicActiveTaskCounter.incrementAndGet();

        future.thenAccept((res) -> {
            synchronized (results) {
                results.put(taskName, res);
            }
            atomicActiveTaskCounter.decrementAndGet();
        });
    }

    public int getActiveTasks() {
        return atomicActiveTaskCounter.get();
    }

    public Optional<Integer> getResult(String taskName) {
        synchronized (results) {
            return Optional.ofNullable(results.get(taskName));
        }
    }
}
