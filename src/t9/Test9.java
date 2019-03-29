package t9;

import java.math.BigInteger;
import java.security.InvalidParameterException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test9 {

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();


        Future<BigInteger> future = service.submit(new Calculator(500));
        BigInteger result = null;

        try{
            result = future.get();

            System.out.println("Result "+result);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
    }

}
