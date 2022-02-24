public class Three {

    private Integer integer = 15;
    private void increment() {
        this.integer++;
    }
    private void decrement() {
        this.integer--;
    }
    public static void main(String[] args) throws InterruptedException{
        Three three = new Three();
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 20000; i++) {
                // Here we are synchronising block
                // This will lock the thread untill all the operations are performed
                synchronized(lock) {
                    three.increment();
                }
            }
        }, "IncrementThread");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 20000; i++) {
                synchronized (lock) {
                    three.decrement();
                }
            }
        }, "DecrementThread");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(three.integer);
    }
    }

