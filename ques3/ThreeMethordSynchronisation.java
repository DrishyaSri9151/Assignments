public class ThreeMethordSynchronisation {
    private static Integer integer = 20;

    private synchronized void increment() {
        integer++;
    }

    private synchronized void decrement() {
        integer--;
    }
    public static void main(String[] args) throws InterruptedException {
        ThreeMethordSynchronisation threeMethordSynchronisation=new ThreeMethordSynchronisation();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 20000; i++) {
                threeMethordSynchronisation.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 20000; i++) {
                threeMethordSynchronisation.decrement();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final Value of Integer: " + integer);
    }
}
