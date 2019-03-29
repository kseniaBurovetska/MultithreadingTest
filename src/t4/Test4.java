package t4;

public class Test4 {

    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        t1.start();

        Thread.sleep(5000);
        t1.myInterrupt();

        System.out.println("Finish");
    }

}

class T1 extends Thread {
    private volatile boolean stop;

    @Override
    public void run() {
        while(!stop){
            System.out.println("T1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
                return;
            }
        }
    }

    void myInterrupt(){
        stop = true;
    }
}