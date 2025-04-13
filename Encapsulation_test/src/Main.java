public class Main {
    public static void main(String[] args) {

        Account myAccount = new Account(1000, "Savings");

        myAccount.savingsEarnings();
        myAccount.deposit(578);
        myAccount.getBalance();
        myAccount.savingsEarnings();
    }
}