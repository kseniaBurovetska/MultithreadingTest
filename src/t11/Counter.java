package t11;

import java.util.concurrent.Callable;

public class Counter implements Callable<Long> {

    private final int[] array;
    private final int from;
    private final int to;

    Counter(int[] array, int from, int to) {
        this.array = array;
        this.from = from;
        this.to = to;
    }

    @Override
    public Long call() throws Exception {
        long res = 0;

        for (int i = from; i < to; i++) {
            res += array[i];
        }

        return res;
    }
}
