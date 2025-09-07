import java.util.Random;

public class BankSystem {

    // BankAccount class
    static class BankAccount {
        String accountHolder;
        int accountNumber;
        double balance;

        // Default constructor → balance = 0
        public BankAccount() {
            this.accountHolder = "Unknown";
            this.accountNumber = generateAccountNumber();
            this.balance = 0.0;
        }

        // Constructor with name → assigns random account number
        public BankAccount(String accountHolder) {
            this.accountHolder = accountHolder;
            this.accountNumber = generateAccountNumber();
            this.balance = 0.0;
        }

        // Constructor with name and initial balance
        public BankAccount(String accountHolder, double balance) {
            this.accountHolder = accountHolder;
            this.accountNumber = generateAccountNumber();
            this.balance = balance;
        }

        // Generate random 6-digit account number
        private int generateAccountNumber() {
            Random rand = new Random();
            return 100000 + rand.nextInt(900000); // generates number between 100000–999999
        }

        // deposit method
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("✅ Deposited ₹" + amount);
            } else {
                System.out.println("❌ Invalid deposit amount.");
            }
        }

        // withdraw method
        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("✅ Withdrawn ₹" + amount);
            } else {
                System.out.println("❌ Insufficient balance or invalid amount.");
            }
        }

        // displayAccount method
        public void displayAccount() {
            System.out.println("🏦 Account Details:");
            System.out.println("Account Holder : " + accountHolder);
            System.out.println("Account Number : " + accountNumber);
            System.out.println("Balance        : ₹" + balance);
            System.out.println("--------------------------------");
        }
    }

    // main method
    public static void main(String[] args) {
        // Account 1: Default constructor
        BankAccount acc1 = new BankAccount();
        acc1.deposit(500);
        acc1.withdraw(200);
        acc1.displayAccount();

        // Account 2: Name only
        BankAccount acc2 = new BankAccount("Alice");
        acc2.deposit(1000);
        acc2.withdraw(1500); // Should show insufficient balance
        acc2.displayAccount();

        // Account 3: Name + initial balance
        BankAccount acc3 = new BankAccount("Bob", 3000);
        acc3.withdraw(1000);
        acc3.deposit(500);
        acc3.displayAccount();
    }
}
