public class Account {

    private double balance;

    public Account(double balance){
        this.balance = balance;
    }

    private double calculateInterest() {
        return balance * 0.05;
    }

    public double getInterest(){
        return calculateInterest();
    }

    public void setBalance(int newBalance){
        this.balance = newBalance;
        System.out.println("Your new account balance is " + this.balance);
    }

    public void getBalance(){
        System.out.println("Your current account balance is " + this.balance);
    }

    public void deposit(double amount){
        this.balance += amount;
        System.out.printf("You have deposited %s.%nYour new account balance is %s.%n", amount, this.balance);
    }

    public void withdraw(double amount){
        if (this.balance - amount < 0){
            System.out.printf("You cannot withdraw that amount. Your current account balance is %.2f", this.balance);
        }else {
            this.balance -= amount;
            System.out.printf("You have withdrawn %s.%nYour new account balance is %s", amount, this.balance);
        }
    }
}
