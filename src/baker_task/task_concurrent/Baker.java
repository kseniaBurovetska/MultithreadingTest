package baker_task.task_concurrent;

public class Baker extends Thread {

    private final Bread bread;

    Baker(Bread bread) {
        this.bread = bread;
    }

    @Override
    public void run() {

        while (bread.getCount() != 0) {
            try {

                Bread.baker.acquire();

                System.out.println("Baker is baking bread");

                Bread.customer.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
