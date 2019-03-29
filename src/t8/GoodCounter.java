package t8;

import java.util.concurrent.atomic.AtomicInteger;

public class GoodCounter implements Counter{

    private AtomicInteger x = new AtomicInteger();


    @Override
    public void increment() {
        x.incrementAndGet();
    }

    @Override
    public String toString() {
        return "GoodCounter{" +
                "x=" + x +
                '}';
    }

}
