import java.util.List;
import java.util.ArrayList;

public class Bank {
    private List<Account> accounts;
    private double flatFee;
    private double percentFee;

    public Bank(double flatFee, double percentFee) {
        this.accounts = new ArrayList<>();
        this.flatFee = flatFee;
        this.percentFee = percentFee;
    }

    
    public void addAccount(Account account) {
        accounts.add(account);
    }

    
    public void performTransaction(Account sender, Account receiver, double amount) {
        double fee = calculateFee(amount);
        double totalAmount = amount + fee;

        if (sender.getBalance() >= totalAmount) {
            Transaction transaction = new Transaction(sender, receiver, amount, Transaction.TransactionType.TRANSFER, sender.getAccountNumber(), receiver.getAccountNumber(), "Transaction");
            transaction.execute();
            sender.withdraw(totalAmount);
            System.out.println("Transaction Successful. Fee: $" + String.format("%.2f", fee));
        } else {
            System.out.println("Insufficient balance for the transaction");
        }
    }

    private double calculateFee(double amount) {
        double fee;
        if (percentFee > 0) {
            fee = amount * (percentFee / 100.0); 
            if (fee < flatFee) {
                fee = flatFee; 
            }
        } else {
            fee = flatFee; 
        }
        return fee;
    }

    
    public void displayAccountInfo() {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
