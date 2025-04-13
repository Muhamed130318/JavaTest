public class Account {

    private double balance;
    private String accountType;

    public Account(double balance, String accountType){
        if (balance < 250){
            System.out.println("Minimum account balance is $250");
        }else {
            this.balance = balance;
        }
        this.accountType = accountType;
    }

    private double calculateInterest() {
        return this.balance * 1.25;
    }

    public double getInterest(){
        return calculateInterest();
    }

    public void savingsEarnings(){
        if (this.accountType.equals("Savings")){
            double interest = calculateInterest();
            double difference = interest - this.balance;
            System.out.printf("You have earned %s of interest on your savings account.%n", difference);
            setBalance(interest);
        }else {
            System.out.println("Your account is not a savings account.");
        }
    }

    public void setAccountType(String newType){
        this.accountType = newType;
        System.out.printf("Your account type is now %s", this.accountType);
    }
    public void getAccountType(){
        System.out.printf("Your account type is %s ", this.accountType);
    }
    public void setBalance(double newBalance){
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
        if (this.balance - amount < 250){
            System.out.printf("You cannot withdraw that amount. Your current account balance is %.2f./nMinimum account balance is $250", this.balance);
        }else {
            this.balance -= amount;
            System.out.printf("You have withdrawn %s.%nYour new account balance is %s", amount, this.balance);
        }
    }
}
