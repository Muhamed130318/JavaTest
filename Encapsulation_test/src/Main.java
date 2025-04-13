public class Main {
    public static void main(String[] args) {

        Account myAccount = new Account(1000, "Savings", "Medo");
        Account myAccount2 = new Account(2500, "Checkings", "Sara");

        myAccount.getBalance();
        myAccount.getHistory();
        myAccount.withdraw(1200);
        myAccount.getHistory();
    }
}