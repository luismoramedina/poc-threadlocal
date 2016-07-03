package luismoramedina;

/**
 * @author luismoramedina
 */
public class Main {

    public static class InfiniteRunnable implements Runnable {

        private MyHolder threadLocal = new MyHolder();

        @Override
        public void run() {
            System.out.println("begin:" + threadLocal.get());
            if (threadLocal.get() == null) {
                threadLocal.put( (int) (Math.random() * 100D) + "");
            }

            try {
                Thread.sleep(1000);
                new Thread(new InfiniteRunnable()).start();
            } catch (InterruptedException ignored) {
            }

            System.out.println("end:" + threadLocal.get());
        }
    }


    public static void main(String[] args) throws InterruptedException {
        InfiniteRunnable sharedRunnableInstance = new InfiniteRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

    }
}
