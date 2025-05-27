public class TraditionalThreadsDemo {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        Thread[] threads = new Thread[100_000];

        for (int i = 0; i < 100_000; i++) {
            threads[i] = new Thread(() -> {
                System.out.println("Hello from traditional thread: " + Thread.currentThread());
            });
            threads[i].start();
        }

        // Join to wait for all threads to finish
        for (Thread thread : threads) {
            thread.join();
        }

        long end = System.currentTimeMillis();
        System.out.println("Completed in " + (end - start) + " ms");
    }
}
