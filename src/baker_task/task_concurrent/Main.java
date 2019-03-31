package baker_task.task_concurrent;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        Bread bread = new Bread();

        Thread baker = new Baker(bread);
        Thread customer = new Customer(bread);

        baker.start();
        customer.start();

    }

}
