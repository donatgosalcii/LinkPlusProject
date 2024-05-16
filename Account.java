public class Account {
    private String accountNumber;
    private String userId; 
    private String userName; 
    private double balance;

    public Account(String accountNumber, String userId, String userName, double balance) {
        this.accountNumber = accountNumber;
        this.userId = userId;
        this.userName = userName;
        this.balance = balance;
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

    public void withdraw(double amount) {
        balance -= amount;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ", User ID: " + userId + ", User Name: " + userName + ", Balance: $" + String.format("%.2f", balance);
    }
}
