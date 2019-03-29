package t8;

public class T1 extends Thread {

    Counter counter;

    T1(Counter counter){
        this.counter = counter;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(System.currentTimeMillis()%500);
        } catch (InterruptedException e) {
            return;
        }

        counter.increment();
    }
}
