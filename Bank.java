import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }
    public void addAccount(Account account) {
        accounts.add(account);
    }

// Method to perform a transaction
public void performTransaction(Account sender, Account receiver, double amount, Transaction.TransactionType type, String originatingAccountId, String resultingAccountId, String reason) {
    if (type == Transaction.TransactionType.TRANSFER) {
        if (sender.getBalance() >= amount) {
            Transaction transaction = new Transaction(sender, receiver, amount, type, originatingAccountId, resultingAccountId, reason);
            transaction.execute();
            System.out.println("Transfer Successful");
        } else {
            System.out.println("Insufficient balance for the transfer");
        }
    } else {
        Transaction transaction = new Transaction(sender, receiver, amount, type, originatingAccountId, null, reason);
        transaction.execute();
    }
}


    public void displayAccountInfo() {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}