package t5;

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

        synchronized (account) {
            int total = account.getMoney();
            if (total >= withdraw) {
                account.setMoney(total - withdraw);
                System.out.println("Withdraw: " + withdraw);
            } else {
                System.out.println("Not enough money. Cannot withdraw: " + withdraw);
            }
        }
    }
}
