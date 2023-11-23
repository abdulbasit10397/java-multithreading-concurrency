package section3;

public class ThreadInterrupt_E1 {
    public static void main (String[] args) {
        Thread thread = new Thread(new BlockingTask());
        thread.start();

        /** The following method is going to invoke the interrupted exception in BlockingTask thread*/
        thread.interrupt();
    }

    private static class BlockingTask implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                System.out.println("Exiting the sleeping thread.");
            }
        }
    }
}
