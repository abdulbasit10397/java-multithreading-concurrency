package section2;

import java.util.ArrayList;
import java.util.List;

public class MultiExecutor {
    public static void main (String[] args) {
        List<Runnable> tasks = new ArrayList<>();
        tasks.add(() -> System.out.println(Thread.currentThread().getName()));
        tasks.add(() -> System.out.println(Thread.currentThread().getName()));
        tasks.add(() -> System.out.println(Thread.currentThread().getName()));

        MultiExecutor multiExecutor = new MultiExecutor(tasks);
        multiExecutor.executeAll();

    }


    List<Thread> threads;

    /*
     * @param tasks to executed concurrently
     */
    public MultiExecutor(List<Runnable> tasks) {
        threads = new ArrayList<>();
        tasks.stream()
                .forEach(task -> threads.add(new Thread(task)));
    }

    /**
     * Starts and executes all the tasks concurrently
     */
    public void executeAll() {
        threads.stream().forEach(t-> t.start());
    }
}
