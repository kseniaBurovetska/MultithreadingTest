package t6;

public class Account {

    private int money;

    public Account(int money) {
        this.money = money;
    }

    int getMoney() {
        return money;
    }

    void setMoney(int money) {
        this.money = money;
    }

    synchronized void withdraw(int amount){
        if(money >= amount){
            money-=amount;
            System.out.println("Withdraw: " + amount);
        } else {
            System.out.println("Not enough money. Cannot withdraw " + amount);
        }
    }
}
