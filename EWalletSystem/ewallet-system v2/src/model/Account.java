package model;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private String username;
    private String password;
    private String phoneNumber;
    private double balance;
    private int age;
    private boolean isAdmin;
    private boolean isActive;
    private List<Transaction> transactions;

    // set safe starting values shared by all constructors
    public Account() {
        this.balance = 0.0;
        this.isAdmin = false;
        this.isActive = true;
        this.transactions = new ArrayList<>();
    }

    // create an admin account using only username, password, and the admin flag
    public Account(String username, String password, boolean isAdmin) {
        this();
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    // create a regular user account with full signup details
    public Account(String username, String password, String phoneNumber, int age) {
        this();
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    // add a transaction record to this account's history
    public void addTransaction(Transaction transaction) {
        if (transactions == null) {
            transactions = new ArrayList<>();
        }
        if (transaction != null) {
            transactions.add(transaction);
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
