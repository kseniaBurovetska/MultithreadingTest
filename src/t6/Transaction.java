package t6;

public class Transaction extends Thread {

    private Account account;
    private int withdraw;

    public Transaction(Account account, int withdraw) {
        this.account = account;
        this.withdraw = withdraw;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(System.currentTimeMillis() % 500);
        } catch (InterruptedException e) {
            return;
        }

        account.withdraw(withdraw);
    }
}
