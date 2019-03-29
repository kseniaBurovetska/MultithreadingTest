package t12;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test12 {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

        try {
            service.scheduleWithFixedDelay(new Timer(), 5, 3, TimeUnit.SECONDS);
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
    }

}

class Timer implements Runnable {

    @Override
    public void run() {
        System.out.println("Tick");
    }
}
