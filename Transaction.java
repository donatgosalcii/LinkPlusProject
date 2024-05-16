public class Transaction {
    public enum TransactionType {
        TRANSFER,
        WITHDRAWAL,
        DEPOSIT
    }

    private TransactionType type;
    private Account sender;
    private Account receiver;
    private double amount;

    public Transaction(Account sender, Account receiver, double amount, TransactionType type) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.type = type;
    }

    public void execute() {
        switch (type) {
            case TRANSFER:
                if (sender.getBalance() >= amount) {
                    sender.withdraw(amount);
                    receiver.deposit(amount);
                    System.out.println("Transfer Successful");
                } else {
                    System.out.println("Insufficient balance for transfer");
                }
                break;
            case WITHDRAWAL:
                if (sender.getBalance() >= amount) {
                    sender.withdraw(amount);
                    System.out.println("Withdrawal Successful");
                } else {
                    System.out.println("Insufficient balance for withdrawal");
                }
                break;
            case DEPOSIT:
                receiver.deposit(amount);
                System.out.println("Deposit Successful");
                break;
        }
    }
}
