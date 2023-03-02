import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorSingleThread {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            executor.execute(() -> {
                String name = Thread.currentThread().getName();
                System.out.println(name);
                for (int i = 0; i < 1_000_000; i++) {
                }
            });
            executor.awaitTermination(1, TimeUnit.MILLISECONDS);
            System.out.println("fora");
        }catch (Throwable e) {
            throw e;
        }finally {
            executor.shutdown();
        }

    }
}
