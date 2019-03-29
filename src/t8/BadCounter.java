package t8;

public class BadCounter implements Counter{

    private volatile  int x;


    @Override
    public void increment() {
        x++;
    }

    @Override
    public String toString() {
        return "BadCounter{" +
                "x=" + x +
                '}';
    }
}
