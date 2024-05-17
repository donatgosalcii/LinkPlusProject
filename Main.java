import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = createBank(scanner);
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Create Account");
            System.out.println("2. Perform Transaction");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Deposit Money");
            System.out.println("5. List Transactions for Account");
            System.out.println("6. Check Account Balance");
            System.out.println("7. List Bank Accounts");
            System.out.println("8. Check Bank Total Transaction Fee Amount");
            System.out.println("9. Check Bank Total Transfer Amount");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createAccount(bank, scanner);
                    break;
                case 2:
                    performTransaction(bank, scanner);
                    break;
                case 3:
                    withdrawMoney(bank, scanner);
                    break;
                case 4:
                    depositMoney(bank, scanner);
                    break;
                case 5:
                    listTransactionsForAccount(bank, scanner);
                    break;
                case 6:
                    checkAccountBalance(bank, scanner);
                    break;
                case 7:
                    listBankAccounts(bank);
                    break;
                case 8:
                    checkTotalTransactionFeeAmount(bank);
                    break;
                case 9:
                    checkTotalTransferAmount(bank);
                    break;
                case 10:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 10.");
            }
        }
    }
    private static Bank createBank(Scanner scanner) {
        System.out.println("Creating a new bank...");
        System.out.print("Enter bank name: ");
        String bankName = scanner.next();
        return new Bank(bankName, 10.0, 0.0); 
    }
    private static void createAccount(Bank bank, Scanner scanner) {
        System.out.println("Creating a new account...");
        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();
        System.out.print("Enter user ID: ");
        String userId = scanner.next();
        System.out.print("Enter user name: ");
        String userName = scanner.next();
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        bank.addAccount(new Account(accountNumber, userId, userName, initialBalance));
        System.out.println("Account created successfully!");
    }
    private static void performTransaction(Bank bank, Scanner scanner) {
        System.out.println("Performing a transaction...");
        System.out.print("Enter sender's account number: ");
        String senderAccountNumber = scanner.next();
        System.out.print("Enter receiver's account number: ");
        String receiverAccountNumber = scanner.next();
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();

        Account sender = findAccountByNumber(bank, senderAccountNumber);
        Account receiver = findAccountByNumber(bank, receiverAccountNumber);

        if (sender != null && receiver != null) {
            bank.performTransaction(sender, receiver, amount);
        } else {
            System.out.println("Sender or receiver account not found.");
        }
    }
    private static void withdrawMoney(Bank bank, Scanner scanner) {
        System.out.print("Enter account number to withdraw from: ");
        String accountNumber = scanner.next();
        Account account = findAccountByNumber(bank, accountNumber);
        if (account != null) {
            System.out.print("Enter amount to withdraw: $");
            double amount = scanner.nextDouble();
            if (account.withdraw(amount)) {
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Insufficient balance for withdrawal.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }
    private static void depositMoney(Bank bank, Scanner scanner) {
        System.out.print("Enter account number to deposit into: ");
        String accountNumber = scanner.next();
        Account account = findAccountByNumber(bank, accountNumber);
        if (account != null) {
            System.out.print("Enter amount to deposit: $");
            double amount = scanner.nextDouble();
            account.deposit(amount);
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Account not found.");
        }
    }
    private static void listTransactionsForAccount(Bank bank, Scanner scanner) {
        System.out.print("Enter account number to list transactions: ");
        String accountNumber = scanner.next();
        Account account = findAccountByNumber(bank, accountNumber);
        if (account != null) {
            List<Transaction> transactions = account.getTransactions();
            if (!transactions.isEmpty()) {
                System.out.println("Transactions for Account " + accountNumber + ":");
                for (Transaction transaction : transactions) {
                    System.out.println(transaction); 
                }
            } else {
                System.out.println("No transactions found for Account " + accountNumber);
            }
        } else {
            System.out.println("Account not found.");
        }
    }
    private static void checkAccountBalance(Bank bank, Scanner scanner) {
        System.out.print("Enter account number to check balance: ");
        String accountNumber = scanner.next();
        Account account = findAccountByNumber(bank, accountNumber);
        if (account != null) {
            System.out.println("Account Balance: $" + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }
    private static void listBankAccounts(Bank bank) {
        System.out.println("Listing bank accounts...");
        bank.displayAccountInfo();
    }
    private static void checkTotalTransactionFeeAmount(Bank bank) {
        System.out.println("Checking total transaction fee amount...");
        System.out.println("Total transaction fee amount: $" + bank.getTotalTransactionFeeAmount());
    }
    private static void checkTotalTransferAmount(Bank bank) {
        System.out.println("Checking total transfer amount...");
        System.out.println("Total transfer amount: $" + bank.getTotalTransferAmount());
    }
    private static Account findAccountByNumber(Bank bank, String accountNumber) {
        for (Account account : bank.getAccounts()) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}
