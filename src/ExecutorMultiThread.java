import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorMultiThread {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Runnable runnable = new MyRunnable();

        try {
            executor.execute(runnable);
            executor.execute(runnable);
            executor.execute(runnable);
            executor.execute(runnable);
            executor.execute(runnable);
            executor.execute(runnable);
            executor.shutdown();
        }catch (Throwable e) {
            throw e;
        }finally {
            executor.shutdown();
        }
        System.out.println("saiu");

    }

    public static class MyRunnable implements Runnable {

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            int nextInt = new Random().nextInt(100);
            System.out.println(name+": "+nextInt);
        }
    }
}
