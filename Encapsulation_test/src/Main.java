public class Main {
    public static void main(String[] args) {

        Account myAccount = new Account(1000);

        System.out.println(myAccount.getInterest());

        myAccount.getBalance();
        myAccount.withdraw(1001);
        myAccount.setBalance(5000);
        myAccount.deposit(21);
    }
}