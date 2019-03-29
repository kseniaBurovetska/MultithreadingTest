package t2;

public class Test2 {

    public static void main(String[] args) {

        Thread t1 = new T1();
        t1.start();


        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finish");

    }

}

class T1 extends Thread {
    @Override
    public void run() {

        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

        System.out.println("Hi, i am "+ this.getClass().getName());
    }
}
