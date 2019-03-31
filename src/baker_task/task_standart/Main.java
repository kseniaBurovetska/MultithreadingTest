package baker_task.task_standart;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Bread bread = new Bread();

        Thread baker = new Baker(bread);
        Thread customer = new Customer(bread);

        baker.start();
        customer.start();

        /*ArrayList<Thread> bakers = new ArrayList<>();
        ArrayList<Thread> customers = new ArrayList<>();

        for(int i = 0; i<10; i++){
            bakers.add(new Baker(bread));
            customers.add(new Customer(bread));
        }

        for(int i = 0; i<10;i++){
            bakers.get(i).start();
            customers.get(i).start();
        }*/
    }

}
