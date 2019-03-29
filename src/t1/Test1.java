package t1;

public class Test1 {

    public static void main(String[] args) {
        Thread t1 = new T1();
        t1.start();


        Thread t2 = new Thread(new T2());
        t2.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("HI, i am " + this.getClass().getName());
            }
        }).start();


        System.out.println("Finish");
    }

}


class T1 extends Thread {

    @Override
    public void run() {
        System.out.println("HI, i am " + this.getClass().getName());
    }
}

class T2 implements Runnable {

    @Override
    public void run() {

        System.out.println("HI, i am " + this.getClass().getName());
    }
}