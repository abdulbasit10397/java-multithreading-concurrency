package section2;

public class ThreadUncaughtException {
    public static void main (String [] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Starting thread...");
            throw new RuntimeException("Oops, thread is crashed");
        });

        thread.setName("Misbehaving Thread");
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("\n\nException Details:");
                System.out.println("Thread: " + t.getName());
                System.out.println("Stack Trace: " + e.getMessage());
            }
        });

        thread.start();
    }
}
