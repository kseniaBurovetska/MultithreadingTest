package t3;

public class Test3 {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new T1();
        t1.start();

        Thread.sleep(4000);

        t1.interrupt();

    }

}

class T1 extends Thread {
    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            System.out.println("T1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
                return;
            }
        }
    }
}
