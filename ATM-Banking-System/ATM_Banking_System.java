import java.util.ArrayList;
import java.util.Scanner;

/*
 * ============================================================
 *                 ATM BANKING SYSTEM
 *                 Core Java Project
 * ============================================================
 *
 * Features:
 * 1. User Login
 * 2. PIN Verification
 * 3. Balance Enquiry
 * 4. Cash Withdrawal
 * 5. Cash Deposit
 * 6. Money Transfer
 * 7. Mini Statement
 * 8. Change PIN
 * 9. Account Details
 * 10. Transaction History
 * 11. ATM Cash Management
 * 12. Logout
 *
 * Technologies:
 * - Core Java
 * - OOP
 * - ArrayList
 * - Scanner
 * - Loops
 * - Conditional Statements
 * - Methods
 * - Encapsulation
 * - Exception Handling
 * ============================================================
 */

class Transaction {

    private String type;
    private double amount;
    private double balance;
    private String description;

    public Transaction(String type, double amount,
                       double balance, String description) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    public void display() {
        System.out.println("-----------------------------------------------");
        System.out.println("Transaction Type : " + type);
        System.out.println("Amount           : ₹" + amount);
        System.out.println("Balance          : ₹" + balance);
        System.out.println("Description      : " + description);
    }
}


class BankAccount {

    private String accountNumber;
    private String holderName;
    private String phoneNumber;
    private String accountType;
    private int pin;
    private double balance;

    private ArrayList<Transaction> transactions;

    public BankAccount(String accountNumber,
                       String holderName,
                       String phoneNumber,
                       String accountType,
                       int pin,
                       double balance) {

        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.phoneNumber = phoneNumber;
        this.accountType = accountType;
        this.pin = pin;
        this.balance = balance;

        transactions = new ArrayList<>();

        addTransaction(
                "ACCOUNT OPENED",
                balance,
                balance,
                "Initial account balance"
        );
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public boolean verifyPin(int enteredPin) {
        return pin == enteredPin;
    }

    public void changePin(int oldPin, int newPin) {

        if (pin != oldPin) {
            System.out.println("\n❌ Incorrect old PIN.");
            return;
        }

        if (newPin < 1000 || newPin > 9999) {
            System.out.println("\n❌ PIN must contain exactly 4 digits.");
            return;
        }

        pin = newPin;

        System.out.println("\n✅ PIN changed successfully.");
    }

    public boolean withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("\n❌ Invalid withdrawal amount.");
            return false;
        }

        if (amount % 100 != 0) {
            System.out.println("\n❌ Amount must be in multiples of ₹100.");
            return false;
        }

        if (amount > balance) {
            System.out.println("\n❌ Insufficient account balance.");
            return false;
        }

        balance -= amount;

        addTransaction(
                "WITHDRAWAL",
                amount,
                balance,
                "Cash withdrawal from ATM"
        );

        System.out.println("\n✅ Please collect your cash.");
        System.out.println("💰 Amount Withdrawn : ₹" + amount);
        System.out.println("💳 Remaining Balance: ₹" + balance);

        return true;
    }

    public boolean deposit(double amount) {

        if (amount <= 0) {
            System.out.println("\n❌ Invalid deposit amount.");
            return false;
        }

        balance += amount;

        addTransaction(
                "DEPOSIT",
                amount,
                balance,
                "Cash deposited into account"
        );

        System.out.println("\n✅ Cash deposited successfully.");
        System.out.println("💰 Deposited Amount : ₹" + amount);
        System.out.println("💳 New Balance      : ₹" + balance);

        return true;
    }

    public boolean transfer(BankAccount receiver, double amount) {

        if (receiver == null) {
            System.out.println("\n❌ Receiver account not found.");
            return false;
        }

        if (receiver == this) {
            System.out.println("\n❌ Cannot transfer money to the same account.");
            return false;
        }

        if (amount <= 0) {
            System.out.println("\n❌ Invalid transfer amount.");
            return false;
        }

        if (amount > balance) {
            System.out.println("\n❌ Insufficient balance.");
            return false;
        }

        balance -= amount;
        receiver.balance += amount;

        addTransaction(
                "TRANSFER",
                amount,
                balance,
                "Money transferred to " + receiver.accountNumber
        );

        receiver.addTransaction(
                "CREDIT",
                amount,
                receiver.balance,
                "Money received from " + accountNumber
        );

        System.out.println("\n✅ Money transferred successfully.");
        System.out.println("Transferred To : " + receiver.holderName);
        System.out.println("Amount         : ₹" + amount);
        System.out.println("Remaining      : ₹" + balance);

        return true;
    }

    private void addTransaction(String type,
                                 double amount,
                                 double balance,
                                 String description) {

        transactions.add(
                new Transaction(
                        type,
                        amount,
                        balance,
                        description
                )
        );
    }

    public void showBalance() {

        System.out.println("\n===============================================");
        System.out.println("                 BALANCE ENQUIRY");
        System.out.println("===============================================");
        System.out.println("Account Holder : " + holderName);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Available      : ₹" + balance);
        System.out.println("===============================================");
    }

    public void showAccountDetails() {

        System.out.println("\n===============================================");
        System.out.println("                ACCOUNT DETAILS");
        System.out.println("===============================================");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Holder Name    : " + holderName);
        System.out.println("Phone Number   : " + phoneNumber);
        System.out.println("Account Type   : " + accountType);
        System.out.println("Balance        : ₹" + balance);
        System.out.println("===============================================");
    }

    public void showMiniStatement() {

        System.out.println("\n===============================================");
        System.out.println("                 MINI STATEMENT");
        System.out.println("===============================================");
        System.out.println("Account Holder : " + holderName);
        System.out.println("Account Number : " + accountNumber);

        if (transactions.isEmpty()) {
            System.out.println("No transactions available.");
        } else {

            int start = Math.max(0, transactions.size() - 10);

            for (int i = start; i < transactions.size(); i++) {
                transactions.get(i).display();
            }
        }

        System.out.println("===============================================");
    }
}


public class ATM_Banking_System {

    static Scanner scanner = new Scanner(System.in);

    static ArrayList<BankAccount> accounts =
            new ArrayList<>();

    static int atmCash = 500000;

    public static void main(String[] args) {

        createSampleAccounts();

        System.out.println("\n");
        System.out.println("=================================================");
        System.out.println("              WELCOME TO MYBANK ATM");
        System.out.println("=================================================");

        while (true) {

            System.out.println("\n1. Login");
            System.out.println("2. Exit");

            int choice = readInt("\nEnter your choice: ");

            switch (choice) {

                case 1:
                    login();
                    break;

                case 2:
                    System.out.println("\nThank you for using MYBANK ATM.");
                    System.out.println("Have a great day! 😊");
                    scanner.close();
                    return;

                default:
                    System.out.println("\n❌ Invalid choice.");
            }
        }
    }


    // -------------------------------------------------------
    // SAMPLE ACCOUNTS
    // -------------------------------------------------------

    static void createSampleAccounts() {

        accounts.add(
                new BankAccount(
                        "1001001001",
                        "Ayyappa",
                        "9876543210",
                        "Savings",
                        1234,
                        50000
                )
        );

        accounts.add(
                new BankAccount(
                        "1001001002",
                        "Rahul",
                        "9876501234",
                        "Savings",
                        2345,
                        75000
                )
        );

        accounts.add(
                new BankAccount(
                        "1001001003",
                        "Priya",
                        "9876512345",
                        "Current",
                        3456,
                        100000
                )
        );
    }


    // -------------------------------------------------------
    // LOGIN
    // -------------------------------------------------------

    static void login() {

        System.out.println("\n===============================================");
        System.out.println("                   ATM LOGIN");
        System.out.println("===============================================");

        String accountNumber =
                readString("Enter Account Number: ");

        BankAccount account =
                findAccount(accountNumber);

        if (account == null) {

            System.out.println("\n❌ Account not found.");
            return;
        }

        int attempts = 3;

        while (attempts > 0) {

            int pin = readInt("Enter 4-Digit PIN: ");

            if (account.verifyPin(pin)) {

                System.out.println("\n✅ Login successful!");
                System.out.println("Welcome, " +
                        account.getHolderName() + "!");

                atmMenu(account);

                return;

            } else {

                attempts--;

                System.out.println(
                        "\n❌ Incorrect PIN."
                );

                System.out.println(
                        "Attempts remaining: " + attempts
                );
            }
        }

        System.out.println(
                "\n🔒 Account temporarily locked."
        );
    }


    // -------------------------------------------------------
    // ATM MENU
    // -------------------------------------------------------

    static void atmMenu(BankAccount account) {

        while (true) {

            System.out.println("\n");
            System.out.println("=================================================");
            System.out.println("                 ATM MAIN MENU");
            System.out.println("=================================================");
            System.out.println("1. Balance Enquiry");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Deposit Cash");
            System.out.println("4. Money Transfer");
            System.out.println("5. Mini Statement");
            System.out.println("6. Account Details");
            System.out.println("7. Change PIN");
            System.out.println("8. ATM Information");
            System.out.println("9. Logout");
            System.out.println("=================================================");

            int choice =
                    readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    account.showBalance();
                    break;

                case 2:
                    withdrawCash(account);
                    break;

                case 3:
                    depositCash(account);
                    break;

                case 4:
                    transferMoney(account);
                    break;

                case 5:
                    account.showMiniStatement();
                    break;

                case 6:
                    account.showAccountDetails();
                    break;

                case 7:
                    changePin(account);
                    break;

                case 8:
                    showATMInformation();
                    break;

                case 9:
                    System.out.println(
                            "\n✅ Successfully logged out."
                    );
                    return;

                default:
                    System.out.println(
                            "\n❌ Invalid choice."
                    );
            }
        }
    }


    // -------------------------------------------------------
    // WITHDRAW CASH
    // -------------------------------------------------------

    static void withdrawCash(BankAccount account) {

        System.out.println("\n===============================================");
        System.out.println("                  CASH WITHDRAWAL");
        System.out.println("===============================================");

        System.out.println(
                "ATM Available Cash: ₹" + atmCash
        );

        double amount =
                readDouble("Enter amount: ");

        if (amount > atmCash) {

            System.out.println(
                    "\n❌ ATM does not have enough cash."
            );

            return;
        }

        if (account.withdraw(amount)) {

            atmCash -= (int) amount;

            System.out.println(
                    "\nATM Remaining Cash: ₹" + atmCash
            );
        }
    }


    // -------------------------------------------------------
    // DEPOSIT CASH
    // -------------------------------------------------------

    static void depositCash(BankAccount account) {

        System.out.println("\n===============================================");
        System.out.println("                   CASH DEPOSIT");
        System.out.println("===============================================");

        double amount =
                readDouble("Enter deposit amount: ");

        if (account.deposit(amount)) {

            atmCash += (int) amount;

            System.out.println(
                    "ATM Cash Updated: ₹" + atmCash
            );
        }
    }


    // -------------------------------------------------------
    // MONEY TRANSFER
    // -------------------------------------------------------

    static void transferMoney(BankAccount sender) {

        System.out.println("\n===============================================");
        System.out.println("                  MONEY TRANSFER");
        System.out.println("===============================================");

        String receiverNumber =
                readString(
                        "Enter Receiver Account Number: "
                );

        BankAccount receiver =
                findAccount(receiverNumber);

        if (receiver == null) {

            System.out.println(
                    "\n❌ Receiver account not found."
            );

            return;
        }

        System.out.println(
                "Receiver Name: " +
                receiver.getHolderName()
        );

        double amount =
                readDouble("Enter transfer amount: ");

        String confirmation =
                readString(
                        "Confirm transfer? (Y/N): "
                );

        if (confirmation.equalsIgnoreCase("Y")) {

            sender.transfer(receiver, amount);

        } else {

            System.out.println(
                    "\n❌ Transfer cancelled."
            );
        }
    }


    // -------------------------------------------------------
    // CHANGE PIN
    // -------------------------------------------------------

    static void changePin(BankAccount account) {

        System.out.println("\n===============================================");
        System.out.println("                    CHANGE PIN");
        System.out.println("===============================================");

        int oldPin =
                readInt("Enter Old PIN: ");

        int newPin =
                readInt("Enter New 4-Digit PIN: ");

        int confirmPin =
                readInt("Confirm New PIN: ");

        if (newPin != confirmPin) {

            System.out.println(
                    "\n❌ New PIN and confirmation PIN do not match."
            );

            return;
        }

        account.changePin(oldPin, newPin);
    }


    // -------------------------------------------------------
    // ATM INFORMATION
    // -------------------------------------------------------

    static void showATMInformation() {

        System.out.println("\n===============================================");
        System.out.println("                  ATM INFORMATION");
        System.out.println("===============================================");
        System.out.println("Bank Name       : MYBANK");
        System.out.println("ATM Type        : Multi-Service ATM");
        System.out.println("ATM Cash        : ₹" + atmCash);
        System.out.println("Supported       : Withdrawal");
        System.out.println("                  Deposit");
        System.out.println("                  Transfer");
        System.out.println("                  Balance Enquiry");
        System.out.println("                  Mini Statement");
        System.out.println("===============================================");
    }


    // -------------------------------------------------------
    // FIND ACCOUNT
    // -------------------------------------------------------

    static BankAccount findAccount(
            String accountNumber) {

        for (BankAccount account : accounts) {

            if (account.getAccountNumber()
                    .equals(accountNumber)) {

                return account;
            }
        }

        return null;
    }


    // -------------------------------------------------------
    // INTEGER INPUT
    // -------------------------------------------------------

    static int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Integer.parseInt(
                        scanner.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "❌ Please enter a valid number."
                );
            }
        }
    }


    // -------------------------------------------------------
    // DOUBLE INPUT
    // -------------------------------------------------------

    static double readDouble(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Double.parseDouble(
                        scanner.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "❌ Please enter a valid amount."
                );
            }
        }
    }


    // -------------------------------------------------------
    // STRING INPUT
    // -------------------------------------------------------

    static String readString(String message) {

        System.out.print(message);

        return scanner.nextLine();
    }
}
