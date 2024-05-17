import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private String userId;
    private String userName;
    private double balance;
    private List<Transaction> transactions; 
    public Account(String accountNumber, String userId, String userName, double balance) {
        this.accountNumber = accountNumber;
        this.userId = userId;
        this.userName = userName;
        this.balance = balance;
        this.transactions= new ArrayList<>();
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public String getUserId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true; 
        } else {
            System.out.println("Insufficient balance for withdrawal");
            return false;
        }
    }
    public List<Transaction> getTransactions() { 
        return transactions;
    }
    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ", User ID: " + userId + ", User Name: " + userName + ", Balance: $" + String.format("%.2f", balance);
    }
}
