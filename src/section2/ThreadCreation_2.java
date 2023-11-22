package section2;


public class ThreadCreation_2 {
    private static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello from: " + this.getName());
        }
    }

    public static void main (String[] args) {
        Thread thread = new MyThread();
        thread.setName("My Thread");
        thread.start();
    }
}
