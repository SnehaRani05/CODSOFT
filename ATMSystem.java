// ATM Interface
// BankAccount class
import java.util.*;
class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        }
        else {
            System.out.println("Initial balance cannot be negative. Setting balance to $0.");
            this.balance = 0;
        } 
    }
    public double getBalance() {
        return balance;
    }
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
            return false;
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Transaction declined.");
            return false;
        } else {
            balance -= amount;
            System.out.println("Transaction successful. Please collect your cash.");
            return true;
        }
    }
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
        } else {
            balance += amount;
            System.out.println("Transaction successful. Amount deposited: $" + amount);
        }
    }
}

// ATM class
class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Exit");
    }

    public void checkBalance() {
        System.out.println("Your current balance is: $" + account.getBalance());
    }

    public void withdraw(double amount) {
        boolean success = account.withdraw(amount);
        if (success) {
            System.out.println("Updated balance: $" + account.getBalance());
        }
    }

    public void deposit(double amount) {
        account.deposit(amount);
        System.out.println("Updated balance: $" + account.getBalance());
    }
}

// Main class
public class ATMSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a user's bank account
        BankAccount userAccount = new BankAccount(1000.00); // Default initial balance
        ATM atm = new ATM(userAccount);

        // ATM menu loop
        while (true) {
            atm.displayMenu();
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter the amount to withdraw: $");
                    double withdrawAmount = sc.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;

                case 3:
                    System.out.print("Enter the amount to deposit: $");
                    double depositAmount = sc.nextDouble();
                    atm.deposit(depositAmount);
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Have a great day!");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}

