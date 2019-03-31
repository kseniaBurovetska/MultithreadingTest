package baker_task.task_concurrent;

import java.util.concurrent.Semaphore;

public class Bread {

    static Semaphore baker = new Semaphore(1);
    static Semaphore customer = new Semaphore(1);

    private int count = 10;

    public Bread() {
        customer.acquireUninterruptibly();
    }

    /*void setBaker() throws InterruptedException {
        customer.release();
        baker.acquire();
    }

    void setCustomer() throws InterruptedException{
        baker.release();
        customer.acquire();
    }*/

    void decreaseCount() {
        count--;
    }

    int getCount() {
        return count;
    }

}
