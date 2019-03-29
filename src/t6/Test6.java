package t6;

import t6.Account;
import t6.Transaction;

import java.util.ArrayList;

public class Test6 {


    public static void main(String[] args) {
        Account account = new Account(1000);

        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(account, 100));
        transactions.add(new Transaction(account, 500));
        transactions.add(new Transaction(account, 300));
        transactions.add(new Transaction(account, 100));
        transactions.add(new Transaction(account, 200));
        transactions.add(new Transaction(account, 250));

        transactions.forEach(Thread::start);

        transactions.forEach(transaction -> {
            try {
                transaction.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        System.out.println("Total left " + account.getMoney());

    }

}
