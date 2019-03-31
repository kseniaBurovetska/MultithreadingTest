package baker_task.task_concurrent;

public class Customer extends Thread {

    private final Bread bread;

    Customer(Bread bread) {
        this.bread = bread;
    }

    @Override
    public void run() {
        while (bread.getCount() != 0) {
            try {

                Bread.customer.acquire();

                System.out.println("Customer bought bread");
                bread.decreaseCount();

                Bread.baker.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
