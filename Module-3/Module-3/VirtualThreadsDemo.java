public class VirtualThreadsDemo {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        // Launching 100,000 virtual threads
        for (int i = 0; i < 100_000; i++) {
            Thread.startVirtualThread(() -> {
                System.out.println("Hello from virtual thread: " + Thread.currentThread());
            });
        }

        long end = System.currentTimeMillis();
        System.out.println("Completed in " + (end - start) + " ms");
    }
}
