import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String bankName;
    private List<Account> accounts;
    private double totalTransactionFeeAmount;
    private double totalTransferAmount;
    private double transactionFlatFeeAmount;
    private double transactionPercentFeeValue;
    public Bank(String bankName, double transactionFlatFeeAmount, double transactionPercentFeeValue) {
        this.bankName = bankName;
        this.accounts = new ArrayList<>();
        this.transactionFlatFeeAmount = transactionFlatFeeAmount;
        this.transactionPercentFeeValue = transactionPercentFeeValue;
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
            totalTransactionFeeAmount += fee;
            totalTransferAmount += amount;
            System.out.println("Transaction Successful. Fee: $" + String.format("%.2f", fee));
        } else {
            System.out.println("Insufficient balance for the transaction");
        }
    }   
    private double calculateFee(double amount) {
        double fee;
        if (transactionPercentFeeValue > 0) {
            fee = amount * (transactionPercentFeeValue / 100.0); 
            if (fee < transactionFlatFeeAmount) {
                fee = transactionFlatFeeAmount; 
            }
        } else {
            fee = transactionFlatFeeAmount; 
        }
        return fee;
    }
    public void displayAccountInfo() {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
    public double getTotalTransactionFeeAmount() {
        return totalTransactionFeeAmount;
    }
    public double getTotalTransferAmount() {
        return totalTransferAmount;
    }
    public List<Account> getAccounts() {
        return accounts;
    }            
}
