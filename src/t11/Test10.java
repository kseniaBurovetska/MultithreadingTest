package t11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Test10 {

    static final int THREADS_COUNT = 4;
    static final int PART_LENGTH = 10000000;

    public static void main(String[] args) {
        int[] array = new int[THREADS_COUNT * PART_LENGTH];
        Arrays.fill(array, 1);

        ExecutorService service = Executors.newFixedThreadPool(THREADS_COUNT);
        CompletionService<Long> completionService = new ExecutorCompletionService<>(service);
        List<Future<Long>> results = new ArrayList<>();
        //int offset = 0;
        long result = 0;

        try {
            for (int i = 0; i < THREADS_COUNT; i++) {
                Counter counter = new Counter(array, i*PART_LENGTH, (i+1)*PART_LENGTH);
                //offset += PART_LENGTH;

                completionService.submit(counter);
                //results.add(future);
            }

            for(int i = 0; i < THREADS_COUNT; i++){
                Future<Long> future = completionService.take();
                result += future.get();
            }

            System.out.println("Result "+ result);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            service.shutdownNow();
        }

    }

}
