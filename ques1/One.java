class ThreadClass implements Runnable{
    @Override
    public void run() {
        System.out.println("Runable interface");
    }
}


public class One{
    public static void main(String[] args) throws InterruptedException {
        ThreadClass t=new ThreadClass();
        Thread t1=new Thread(t);
        Thread t2=new Thread(t);
        // If we run this code without join then Hello will be printed first and then the Runnable interface
        t1.start();
        t2.start();
        // If we apply join here then we will then the main thread will wait here to join back and then complete the further execution
        t1.join();
        t2.join();
        // sleep will make the code sleep for the time w give
        Thread.sleep(1000);
        System.out.println("Hello");


    }
}
