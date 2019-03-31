package baker_task.task_standart;

public class Customer extends Thread {

    private final Bread bread;

    Customer(Bread bread){
        this.bread = bread;
    }

    @Override
    public void run() {
        while(bread.count()!=0) {
            synchronized (bread) {
                if (!bread.isReady()) {
                    try {
                        //System.out.println("Customer is waiting for bread");
                        bread.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {

                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                    System.out.println("Customer bought bread");
                    bread.setReady(false);
                    bread.decreaseCount();
                    bread.notify();
                }
            }
        }
    }
}
