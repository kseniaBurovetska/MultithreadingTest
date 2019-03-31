package baker_task.task_standart;

public class Baker extends Thread {

    private final Bread bread;

    Baker(Bread bread){
        this.bread = bread;
    }

    @Override
    public void run() {

        while(bread.count()!=0) {
            synchronized (bread) {
                if (bread.isReady()) {
                    try {
                        bread.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {

                    try {
                        sleep(System.currentTimeMillis() % 500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Baker is baking bread");
                    bread.setReady(true);
                    bread.notify();
                }
            }
        }
    }

}
