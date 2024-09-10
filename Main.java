import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void checkBalance() {
        double balance = bankAccount.getBalance();
        System.out.printf("Your current balance is $%.2f%n", balance);
    }

    public void deposit() {
        System.out.print("Enter amount to deposit: ");
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            if (bankAccount.deposit(amount)) {
                System.out.printf("Successfully deposited $%.2f.%n", amount);
            } else {
                System.out.println("Deposit amount must be greater than zero.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a numeric value.");
        }
    }

    public void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            if (bankAccount.withdraw(amount)) {
                System.out.printf("Successfully withdrew $%.2f.%n", amount);
            } else {
                System.out.println("Insufficient funds or invalid amount.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a numeric value.");
        }
    }

    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Choose an option (1-4): ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    checkBalance();
                    break;
                case "2":
                    deposit();
                    break;
                case "3":
                    withdraw();
                    break;
                case "4":
                    System.out.println("Exiting. Have a great day!");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option (1-4).");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        double initialBalance = 1000.00; // Starting balance for the user
        BankAccount account = new BankAccount(initialBalance);
        ATM atm = new ATM(account);
        atm.run();
    }
}
