import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Account {

    private String accNumber;
    Scanner input = new Scanner(System.in);
    private double balance;
    private String accountType;
    private String accName;
    private ArrayList<String> transactionHistory = new ArrayList<>();

    public Account(double balance, String accountType, String accName){
        if (balance < 0){
            System.out.println("Minimum account balance is $0");
        }else {
            this.balance = balance;
        }
        this.accountType = accountType;
        this.accName = accName;
        this.accNumber = loadAccNumber();//generateAccNumber();
        if (loadAccNumber() == null){
            this.accNumber = generateAccNumber();
            saveAccNumber(this.accNumber);
        }
    }

    private String loadAccNumber(){
        File file = new File("account_number.txt");

        if (!file.exists()){
            return null;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            return reader.readLine();
        }catch (IOException e){
            System.out.println("Error reading account number " + e.getMessage());
            return null;
        }
    }

    private String generateAccNumber(){
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 12).toUpperCase();
    }

    private void saveAccNumber(String number){
        try (FileWriter writer = new FileWriter("account_number.txt")) {
            writer.write(number);
        }catch (IOException e) {
            System.out.println("Error saving account number" + e.getMessage() + ".");
        }
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
            transactionHistory.add("Savings earned " + difference);
        }else {
            System.out.println("Your account is not a savings account.");
        }
    }

    private void overdraft(double amount){
        double remaining = 0;
        double overAmount = 0;
        if (this.balance - amount < -1000){
            remaining = -1000 + this.balance;
            System.out.printf("Insufficient funds.%nAccount balance is %.2f.%nYour maximum overdraft amount is %s.", this.balance, remaining);
            transactionHistory.add("Overdraft withdrawal failed, not enough funds");
        }else {
            overAmount = amount - this.balance;
            this.balance -= amount;
            System.out.printf("Overdraft successful.%nCurrent account balance is " + this.balance + "%n");
            transactionHistory.add("Successful overdraft of " + overAmount);
        }
    }

    public void getHistory(){
        System.out.printf("Your transaction history: %s%n", this.transactionHistory);
    }

    public void getAccNumber(){
        System.out.println(this.accNumber);
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
        transactionHistory.add("Check account balance");
    }

    public void deposit(double amount){
        this.balance += amount;
        System.out.printf("You have deposited %s.%nYour new account balance is %s.%n", amount, this.balance);
        transactionHistory.add("Successfully deposited " + amount);
    }

    public void withdraw(double amount){
        if (this.balance - amount < 0){
            System.out.printf("You cannot withdraw that amount. Your current account balance is %.2f.%nMinimum account balance is $0.%n", this.balance);
            System.out.printf("Would you like to overdraft? Yes/No");
            //dodat provjeru jel vec na max overdraft
            String overdraftAnsw = input.nextLine();
            if (overdraftAnsw.equals("Yes") && this.balance == -1000){
                System.out.printf("Insufficient funds./nMaximum overdraft is $-1000.%nYour account balance is: $.2f.%n", this.balance);
                transactionHistory.add("Failed withdrawal of " + amount + ", Insufficient funds.");
            }else if (overdraftAnsw.equals("No")) {
                System.out.println("Thank you for using our services.");
                transactionHistory.add("Failed withdrawal of " + amount);
            }else{
                overdraft(amount);
                return;
            }
        }else {
            this.balance -= amount;
            System.out.printf("You have withdrawn %s.%nYour new account balance is %s", amount, this.balance);
            transactionHistory.add("Successful withdrawal of " + amount);
        }
    }
}
