import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Two {
    public static void main(String[] args){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> System.out.println("Single Thread Executor"));
        ExecutorService executor1 = Executors.newCachedThreadPool();
        executor1.execute(() -> System.out.println("New Cached Thread Pool"));

        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10 ; i++) {
            es.submit(() -> {
                System.out.println("Doing through executor");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        es.shutdown();
        try {
            es.awaitTermination(2, TimeUnit.DAYS);
            System.out.println("Here");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
