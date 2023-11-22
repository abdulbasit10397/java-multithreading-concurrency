package section2;

public class ThreadCreation_1 {
    public static void main (String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("We are now in thread: " + Thread.currentThread().getName());
                System.out.println("Current thread priority: " + Thread.currentThread().getPriority());
            }
        });

        thread.setName("New Worker Thread.");
        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("We are in thread: '" + Thread.currentThread().getName() + "' before starting new thread.");

        /** You will notice that after running this line, OS is still in main thread because new thread
         hasn't been scheduled yet. OS takes a little time to schedule & run it */
        thread.start();

        System.out.println("We are in thread: '" + Thread.currentThread().getName() + "' after starting new thread.");
        Thread.sleep(1000);
    }
}
