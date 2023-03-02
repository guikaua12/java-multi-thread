public class Main {
    private static int i = 0;
    public static void main(String[] args) {
        Runnable runnable = new MeuRunnable();
        Thread t0 = new Thread(runnable);
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        Thread t4 = new Thread(runnable);

        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    private static class MeuRunnable implements Runnable {
        private Object object1 = new Object();
        private Object object2 = new Object();

        @Override
        public void run() {
            synchronized (object1) {
                i++;
                String name = Thread.currentThread().getName();
                System.out.println(name+" : "+i);
            }
            synchronized (object1) {
                i++;
                String name = Thread.currentThread().getName();
                System.out.println(name+" : "+i);
            }
        }
    }
}