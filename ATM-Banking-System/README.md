# 🏧 ATM Banking System — Core Java

A console-based **ATM Banking System** developed using **Core Java**.

This project simulates the basic operations of a real-world ATM, including secure login, PIN verification, balance enquiry, cash withdrawal, cash deposit, money transfer, transaction history, PIN change, and ATM cash management.

The project is designed to demonstrate practical knowledge of **Java programming, Object-Oriented Programming (OOP), Collections, Methods, Encapsulation, Exception Handling, Loops, Conditional Statements, and User Input Handling**.

---

## 📌 Project Overview

The ATM Banking System allows users to securely log in using their account number and PIN and perform different banking operations.

### Main Features

* 🔐 Secure Account Login
* 🔢 4-Digit PIN Verification
* 💰 Balance Enquiry
* 💵 Cash Withdrawal
* 💳 Cash Deposit
* 🔄 Money Transfer
* 📄 Mini Statement
* 📋 Account Details
* 🔑 Change PIN
* 🏧 ATM Cash Management
* 🧾 Transaction History
* 🚫 Invalid Input Handling
* 🔒 Failed Login Attempt Limitation
* 👥 Multiple Bank Accounts
* 🚪 Secure Logout

---

## 🛠️ Technologies Used

* **Java**
* **Core Java**
* **Object-Oriented Programming**
* **ArrayList**
* **Scanner**
* **Exception Handling**
* **Conditional Statements**
* **Loops**
* **Methods**
* **Encapsulation**

---

## 📂 Project Structure

```text
ATM-Banking-System/
│
├── ATM_Banking_System.java
│
└── README.md
```

---

## 🧠 Core Java Concepts Used

This project demonstrates several important Core Java concepts.

### 1. Classes and Objects

The project uses multiple classes to represent real-world banking entities.

```java
class BankAccount {
    // Account details and banking operations
}
```

```java
class Transaction {
    // Transaction information
}
```

---

### 2. Encapsulation

Account information such as PIN, balance, phone number, and account number are kept private and accessed through methods.

```java
private String accountNumber;
private String holderName;
private int pin;
private double balance;
```

---

### 3. ArrayList

`ArrayList` is used to store multiple bank accounts and transaction records.

```java
ArrayList<BankAccount> accounts;
```

```java
ArrayList<Transaction> transactions;
```

---

### 4. Methods

The application is divided into multiple methods for better organization.

Examples:

```text
login()
atmMenu()
withdrawCash()
depositCash()
transferMoney()
changePin()
showATMInformation()
findAccount()
```

---

### 5. Exception Handling

Invalid numeric input is handled using `try-catch`.

```java
try {
    return Integer.parseInt(scanner.nextLine());
}
catch (NumberFormatException e) {
    System.out.println("Invalid input");
}
```

---

### 6. Conditional Statements

The project uses `if`, `else`, and `switch` statements for decision making.

---

### 7. Loops

`while` and `for` loops are used for:

* ATM menu
* Login attempts
* Account searching
* Transaction display

---

## 🔐 Demo Login Credentials

The application contains three sample accounts.

| Account Number | Account Holder |    PIN | Initial Balance |
| -------------- | -------------- | -----: | --------------: |
| `1001001001`   | Ayyappa        | `1234` |         ₹50,000 |
| `1001001002`   | Rahul          | `2345` |         ₹75,000 |
| `1001001003`   | Priya          | `3456` |       ₹1,00,000 |

> **Note:** These credentials are created only for demonstration purposes.

---

# 🚀 How to Run the Project

## Step 1 — Install Java

Make sure Java JDK is installed.

Check Java version:

```bash
java -version
```

Check Java compiler:

```bash
javac -version
```

---

## Step 2 — Create Project Folder

Create a folder named:

```text
ATM-Banking-System
```

---

## Step 3 — Create Java File

Inside the folder create:

```text
ATM_Banking_System.java
```

Copy the complete Java source code into this file.

---

## Step 4 — Open in VS Code

Open the project folder in **Visual Studio Code**.

```text
ATM-Banking-System
        │
        ├── ATM_Banking_System.java
        └── README.md
```

---

## Step 5 — Compile the Program

Open the VS Code Terminal and run:

```bash
javac ATM_Banking_System.java
```

If there are no errors, Java will compile the program successfully.

---

## Step 6 — Run the Program

Run:

```bash
java ATM_Banking_System
```

---

# 🖥️ Application Flow

```text
                ATM BANKING SYSTEM
                        │
                        ▼
                  Welcome Screen
                        │
                        ▼
                      Login
                        │
              ┌─────────┴─────────┐
              │                   │
          Valid PIN            Invalid PIN
              │                   │
              ▼                   ▼
          ATM Menu            Retry Login
              │
     ┌────────┼────────┬─────────┐
     │        │        │         │
     ▼        ▼        ▼         ▼
  Balance  Withdraw  Deposit  Transfer
     │        │        │         │
     └────────┴────────┴─────────┘
                    │
                    ▼
              Other Services
                    │
          ┌─────────┼─────────┐
          │         │         │
          ▼         ▼         ▼
       Statement  Change PIN  Details
                    │
                    ▼
                  Logout
```

---

# 💰 ATM Operations

## 1. Balance Enquiry

Users can check their current account balance.

Example:

```text
Account Holder : Ayyappa
Account Number : 1001001001
Available      : ₹50000.0
```

---

## 2. Cash Withdrawal

Users can withdraw money from their account.

The system checks:

* Valid amount
* Sufficient account balance
* ATM available cash
* Amount in multiples of ₹100

Example:

```text
Enter amount: 5000

Please collect your cash.

Amount Withdrawn : ₹5000
Remaining Balance: ₹45000
```

---

## 3. Cash Deposit

Users can deposit money into their account.

The account balance and ATM cash are updated automatically.

---

## 4. Money Transfer

Users can transfer money to another registered bank account.

The system validates:

* Receiver account
* Sender balance
* Transfer amount
* Same-account transfer

Both sender and receiver transaction histories are updated.

---

## 5. Mini Statement

The application maintains transaction records and displays the latest transactions.

Example:

```text
Transaction Type : WITHDRAWAL
Amount           : ₹5000
Balance          : ₹45000
Description      : Cash withdrawal from ATM
```

---

## 6. Change PIN

Users can change their existing PIN.

The system validates:

* Old PIN
* New PIN
* 4-digit PIN
* PIN confirmation

---

## 7. ATM Cash Management

The application also maintains the available cash inside the ATM.

Example:

```text
Initial ATM Cash : ₹500000
Withdrawal       : ₹10000
Remaining Cash   : ₹490000
```

---

# 📋 ATM Main Menu

```text
=================================================
                 ATM MAIN MENU
=================================================
1. Balance Enquiry
2. Withdraw Cash
3. Deposit Cash
4. Money Transfer
5. Mini Statement
6. Account Details
7. Change PIN
8. ATM Information
9. Logout
=================================================
```

---

# 🧾 Transaction Types

The system supports different transaction types:

```text
ACCOUNT OPENED
WITHDRAWAL
DEPOSIT
TRANSFER
CREDIT
```

Each transaction stores:

* Transaction type
* Amount
* Current balance
* Description

---

# 🔒 Security Features

The project includes basic ATM security mechanisms:

* Account number verification
* PIN verification
* Maximum login attempts
* PIN change validation
* Transfer confirmation
* Input validation

After three incorrect PIN attempts, the login process is stopped.

---

# 📊 Sample Workflow

### Login

```text
Enter Account Number: 1001001001
Enter 4-Digit PIN: 1234

Login successful!
Welcome, Ayyappa!
```

### Balance

```text
Account Holder : Ayyappa
Account Number : 1001001001
Available      : ₹50000.0
```

### Withdrawal

```text
Enter amount: 5000

Please collect your cash.
Amount Withdrawn : ₹5000
Remaining Balance: ₹45000
```

### Transfer

```text
Receiver Account Number: 1001001002
Receiver Name: Rahul

Enter transfer amount: 10000
Confirm transfer? (Y/N): Y

Money transferred successfully.
Transferred To : Rahul
Amount         : ₹10000
Remaining      : ₹35000
```

---

# 🎯 Learning Objectives

This project helps beginners understand how Core Java concepts can be combined to build a practical application.

### After completing this project, you can practice:

* Java syntax
* Classes and objects
* Constructors
* Encapsulation
* ArrayList
* Methods
* Loops
* Conditional statements
* Switch statements
* Exception handling
* Input validation
* Object interaction
* Basic application design

---

# 🔮 Future Enhancements

The current project is a console-based application. It can be extended into a more advanced banking application.

Possible future improvements:

* 🗄️ MySQL Database Integration
* 🔌 JDBC Integration
* 🌐 Web Application
* 🎨 GUI using Java Swing or JavaFX
* 🔐 Password/PIN encryption
* 📧 Email notifications
* 📱 Mobile banking support
* 🧑‍💼 Admin dashboard
* 📊 Banking analytics
* 🧾 PDF statement generation
* 🔑 OTP verification
* 💳 Card management
* 🏦 Loan management
* 💰 Interest calculation
* 📅 Account statement by date
* 🌐 REST API using Spring Boot

---

# 👨‍💻 Author

**Ayyappa**

### Project

**ATM Banking System**

### Technology

**Core Java**

---

# ⭐ Project Highlights

```text
✔ Core Java
✔ Object-Oriented Programming
✔ Multiple Classes
✔ ArrayList
✔ Encapsulation
✔ Exception Handling
✔ Transaction Management
✔ ATM Cash Management
✔ Money Transfer
✔ PIN Management
✔ Mini Statement
✔ Input Validation
✔ Multiple Accounts
```

---

## 📌 Disclaimer

This project is created for **educational and demonstration purposes**.

It is a console-based simulation and does not connect to a real banking system or process real financial transactions.
