package t8;

import java.util.ArrayList;

public class Test8 {

    public static void main(String[] args) throws InterruptedException {
        check(new BadCounter());
        check(new GoodCounter());
    }


    static void check(Counter counter) throws InterruptedException {

        ArrayList<T1> threads = new ArrayList<>();

        for(int i=0;i<100;i++){
            T1 thread = new T1(counter);
            threads.add(thread);
            thread.start();

        }

        for(T1 t1 : threads){
            t1.join();
        }

        System.out.println(counter);
    }
}
