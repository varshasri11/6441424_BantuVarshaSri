import java.util.*;
import java.util.concurrent.*;

public class ExecutorServiceCallable {
    public static void main(String[] args) {
        // Create a fixed thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // List to store Future results
        List<Future<String>> futures = new ArrayList<>();

        // Submit 5 Callable tasks
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            Future<String> future = executor.submit(() -> {
                Thread.sleep(1000); // Simulate some delay
                return "Result from Task " + taskId + " by " + Thread.currentThread().getName();
            });
            futures.add(future);
        }

        // Retrieve and print results
        for (Future<String> future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // Shutdown the executor
        executor.shutdown();
    }
}
