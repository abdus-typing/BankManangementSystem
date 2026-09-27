# Bank Management System

A desktop banking application built with Java (Swing/AWT) and MySQL via JDBC. Workflow — new customer registration across a multi-page form, card/PIN login, and standard ATM transactions (deposit, withdrawal, fast cash, balance enquiry, mini statement, PIN change).



## Tech Stack

- **Language:** Java (Swing, AWT), OOPs
- **Database:** MySQL 8
- **Connectivity:** JDBC (`mysql-connector-j-8.0.33`)
- **IDE:** IntelliJ IDEA

## Features

- **Login** — authenticate with card number + PIN against stored credentials
- **Registration (3-page form)**
  - Page 1: personal details (name, DOB, gender, contact info, address)
  - Page 2: additional KYC details (religion, category, education, occupation, income bracket, PAN, Aadhaar, senior citizen / existing account status)
  - Page 3: account type selection, service preferences, and final submission — generates a card number and PIN
- **Transactions menu**
  - Deposit
  - Cash Withdrawal (with live balance check to block overdrafts)
  - Fast Cash (preset withdrawal amounts)
  - Balance Enquiry
  - Mini Statement (transaction history + running balance)
  - Change PIN
  - Exit

## Project Structure

```
bank/management/system/
├── login.java          # Login screen
├── signup.java         # Registration page 1
├── SignupTwo.java       # Registration page 2
├── signupThree.java     # Registration page 3 (final submit)
├── Transactions.java     # Main post-login menu
├── Deposit.java
├── Withdraw.java
├── fastCash.java
├── BalEnquiry.java
├── miniStatement.java
├── changePIN.java
└── conn.java             # JDBC connection handler
```

## Getting Started

```bash
git clone https://github.com/abdus-typing/Bank-management-system.git
```

Open the project in IntelliJ IDEA (or your IDE of choice), then follow the **Database Setup** and **Dependencies** sections below before running.

> **Note:** `config.properties` (database credentials) is intentionally excluded from version control via `.gitignore`. You must create your own local copy — see the Database Setup section — before the app will run.

## Database Setup

1. Create the database and tables:

```sql
CREATE DATABASE bankmanagementsystem;
USE bankmanagementsystem;

CREATE TABLE signup(
    formno varchar(20), name varchar(20), father_name varchar(20),
    dob varchar(20), gender varchar(20), phone varchar(15),
    email varchar(50), marital varchar(20), address varchar(50),
    city varchar(20), pin varchar(10), state varchar(20), country varchar(20)
);

CREATE TABLE login(
    formno varchar(20), cardNumber varchar(30), pin_no varchar(10)
);

CREATE TABLE signupTwo(
    Formno varchar(20), Religion varchar(20), Category varchar(20),
    EducationalQualification varchar(30), Occupation varchar(20),
    Income varchar(70), PAN varchar(15), Aadhar varchar(20),
    SeniorCitizen varchar(20), ExistingAC varchar(20)
);

CREATE TABLE signupthree(
    Formno varchar(20), AccountType varchar(100), cardNumber varchar(30),
    pin_no varchar(10), servicesRequired varchar(255)
);

CREATE TABLE bank(
    card_no varchar(20), pin varchar(20), date varchar(50),
    type varchar(20), amount varchar(20)
);
```

2. Create a `config.properties` file in the project root (this file is git-ignored and must **not** be committed):

```properties
db.url=jdbc:mysql://localhost:3306/bankmanagementsystem
db.user=your_mysql_user
db.password=your_mysql_password
```

> It's recommended to create a dedicated MySQL user scoped to just this database rather than using `root`:
> ```sql
> CREATE USER 'bankapp'@'localhost' IDENTIFIED BY 'a_real_password';
> GRANT ALL PRIVILEGES ON bankmanagementsystem.* TO 'bankapp'@'localhost';
> FLUSH PRIVILEGES;
> ```

## Dependencies

Add these as module dependencies (Project Structure → Modules → Dependencies) on **every module** your source lives under:

- `mysql-connector-j-8.0.33.jar`
- `jcalendar-1.4.jar`

If running on a modern JDK (9+), JCalendar may require an extra VM option due to the Java Platform Module System:

```
--add-exports=java.desktop/javax.swing.plaf.basic=ALL-UNNAMED
```
>All the best!


## Author

Abdus Salam
