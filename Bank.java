import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    // Method to add an account to the bank
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // Method to perform a transaction
    public void performTransaction(Account sender, Account receiver, double amount) {
        if (sender.getBalance() >= amount) {
            Transaction transaction = new Transaction(sender, receiver, amount);
            transaction.execute();
            System.out.println("Transaction Successful");
        } else {
            System.out.println("Insufficient balance for the transaction");
        }
    }

    // Method to display account information
    public void displayAccountInfo() {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}