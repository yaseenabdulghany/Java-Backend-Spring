package service.impl;

import model.Account;
import model.Transaction;
import service.AccountService;
import service.ApplicationService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class EWalletApplicationServiceImpl implements ApplicationService {

    private final AccountService accountService = new AccountServiceImpl();
    // reuse one scanner for the whole session to avoid resource leaks
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void start() {
        System.out.println("welcome to yaseen ewallet");

        int invalidCount = 0;
        boolean running = true;

        while (running) {
            System.out.println("\nmain menu:");
            System.out.println("1. login");
            System.out.println("2. signup");
            System.out.println("3. exit");

            int choice = readInt("choose: ");

            switch (choice) {
                case 1:
                    login();
                    invalidCount = 0;
                    break;
                case 2:
                    signup();
                    invalidCount = 0;
                    break;
                case 3:
                    System.out.println("have a nice day");
                    running = false;
                    break;
                default:
                    System.out.println("invalid option, please choose 1, 2, or 3");
                    invalidCount++;
            }

            if (invalidCount >= 4) {
                System.out.println("too many invalid choices, closing the application");
                running = false;
            }
        }
    }

    // ask for credentials and allow up to 3 attempts before returning to the main menu
    private void login() {
        int attempts = 0;
        int maxAttempts = 3;

        while (attempts < maxAttempts) {
            String username = readLine("enter username: ");
            String password = readLine("enter password: ");

            if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
                System.out.println("username and password cannot be empty");
                attempts++;
                continue;
            }

            Account account = accountService.login(username, password);

            if (account == null) {
                attempts++;
                int remaining = maxAttempts - attempts;
                if (remaining > 0) {
                    System.out.println("wrong username or password, attempts left: " + remaining);
                }
                continue;
            }

            if (!account.isActive()) {
                System.out.println("this account is deactivated, please contact admin");
                return;
            }

            System.out.println("welcome back, " + account.getUsername());

            if (account.isAdmin()) {
                adminMenu(account);
            } else {
                profileMenu(account);
            }
            return;
        }

        System.out.println("too many failed attempts, returning to main menu");
    }

    // collect and validate all signup fields then create the account
    private void signup() {
        System.out.println("\nsignup:");

        String username = readLine("enter username (min 3 chars, must start with uppercase letter): ");
        if (username == null || username.isEmpty()) {
            System.out.println("username cannot be empty");
            return;
        }
        if (!isValidUsername(username)) {
            System.out.println("username must be at least 3 characters and start with an uppercase letter");
            return;
        }
        if (accountService.findByUsername(username) != null) {
            System.out.println("this username is already taken");
            return;
        }

        String password = readLine("enter password (min 6 chars, must include letters and numbers): ");
        if (password == null || password.isEmpty()) {
            System.out.println("password cannot be empty");
            return;
        }
        if (!isValidPassword(password)) {
            System.out.println("password must be at least 6 characters and include both letters and numbers");
            return;
        }

        int age = readInt("enter age: ");
        if (age == -1) {
            System.out.println("please enter a valid age");
            return;
        }
        if (age < 18) {
            System.out.println("you must be at least 18 years old to register");
            return;
        }

        String phone = readLine("enter phone number (egypt format, e.g. 01012345678): ");
        if (phone == null || phone.isEmpty()) {
            System.out.println("phone number cannot be empty");
            return;
        }
        if (!isValidPhone(phone)) {
            System.out.println("phone must be 11 digits and start with 010, 011, 012, or 015");
            return;
        }
        if (accountService.findByPhone(phone) != null) {
            System.out.println("this phone number is already registered");
            return;
        }

        Account newAccount = new Account(username, password, phone, age);
        boolean created = accountService.createAccount(newAccount);

        if (created) {
            System.out.println("account created successfully");
            profileMenu(newAccount);
        } else {
            System.out.println("failed to create account, please try again");
        }
    }

    // show the main feature menu for a logged-in regular user
    private void profileMenu(Account account) {
        boolean loggedIn = true;

        while (loggedIn) {
            System.out.println("\nprofile menu (" + account.getUsername() + ")");
            System.out.println("balance: " + account.getBalance() + " egp");
            System.out.println("1. deposit");
            System.out.println("2. withdraw");
            System.out.println("3. transfer");
            System.out.println("4. show account details");
            System.out.println("5. change password");
            System.out.println("6. transaction history");
            System.out.println("7. delete account");
            System.out.println("8. deactivate account");
            System.out.println("9. logout");

            int choice = readInt("choose: ");

            switch (choice) {
                case 1:
                    deposit(account);
                    break;
                case 2:
                    withdraw(account);
                    break;
                case 3:
                    transfer(account);
                    break;
                case 4:
                    showDetails(account);
                    break;
                case 5:
                    changePassword(account);
                    break;
                case 6:
                    showTransactions(account);
                    break;
                case 7:
                    if (deleteAccount(account)) {
                        loggedIn = false;
                    }
                    break;
                case 8:
                    if (deactivateAccount(account)) {
                        loggedIn = false;
                    }
                    break;
                case 9:
                    System.out.println("logged out, goodbye " + account.getUsername());
                    loggedIn = false;
                    break;
                default:
                    System.out.println("invalid option");
            }
        }
    }

    // show the admin panel with options to manage accounts
    private void adminMenu(Account admin) {
        boolean loggedIn = true;

        while (loggedIn) {
            System.out.println("\nadmin panel (" + admin.getUsername() + ")");
            System.out.println("1. view all accounts");
            System.out.println("2. activate or deactivate an account");
            System.out.println("3. logout");

            int choice = readInt("choose: ");

            switch (choice) {
                case 1:
                    viewAllAccounts();
                    break;
                case 2:
                    manageAccountStatus();
                    break;
                case 3:
                    System.out.println("admin logged out");
                    loggedIn = false;
                    break;
                default:
                    System.out.println("invalid option");
            }
        }
    }

    // add money to the user account after validating the amount
    private void deposit(Account account) {
        double amount = readDouble("enter deposit amount: ");
        if (amount <= 0) {
            System.out.println("amount must be greater than zero");
            return;
        }

        boolean success = accountService.deposit(account.getUsername(), amount);
        if (success) {
            System.out.println("deposit successful, new balance: " + account.getBalance() + " egp");
        } else {
            System.out.println("deposit failed, please try again");
        }
    }

    // remove money from the user account after checking amount and balance
    private void withdraw(Account account) {
        double amount = readDouble("enter withdraw amount: ");
        if (amount <= 0) {
            System.out.println("amount must be greater than zero");
            return;
        }

        if (account.getBalance() < amount) {
            System.out.println("not enough balance, your current balance is: " + account.getBalance() + " egp");
            return;
        }

        boolean success = accountService.withdraw(account.getUsername(), amount);
        if (success) {
            System.out.println("withdraw successful, new balance: " + account.getBalance() + " egp");
        } else {
            System.out.println("withdraw failed, please try again");
        }
    }

    // send money from the logged-in user to another account
    private void transfer(Account account) {
        String targetUsername = readLine("enter the username to send money to: ");
        if (targetUsername == null || targetUsername.isEmpty()) {
            System.out.println("username cannot be empty");
            return;
        }

        if (targetUsername.equals(account.getUsername())) {
            System.out.println("you cannot transfer money to yourself");
            return;
        }

        Account target = accountService.findByUsername(targetUsername);
        if (target == null) {
            System.out.println("account not found: " + targetUsername);
            return;
        }

        double amount = readDouble("enter transfer amount: ");
        if (amount <= 0) {
            System.out.println("amount must be greater than zero");
            return;
        }

        if (account.getBalance() < amount) {
            System.out.println("not enough balance, your current balance is: " + account.getBalance() + " egp");
            return;
        }

        boolean success = accountService.transfer(account.getUsername(), targetUsername, amount);
        if (success) {
            System.out.println("transfer successful");
            System.out.println("your new balance: " + account.getBalance() + " egp");
        } else {
            System.out.println("transfer failed, please try again");
        }
    }

    // print the account information to the screen
    private void showDetails(Account account) {
        System.out.println("\naccount details:");
        System.out.println("username : " + account.getUsername());
        System.out.println("phone    : " + (account.getPhoneNumber() != null ? account.getPhoneNumber() : "not set"));
        System.out.println("age      : " + (account.getAge() > 0 ? account.getAge() : "n/a"));
        System.out.println("balance  : " + account.getBalance() + " egp");
        System.out.println("status   : " + (account.isActive() ? "active" : "inactive"));
        System.out.println("type     : " + (account.isAdmin() ? "admin" : "user"));
    }

    // let the user update their password after verifying the current one
    private void changePassword(Account account) {
        String oldPassword = readLine("enter current password: ");
        if (oldPassword == null || oldPassword.isEmpty()) {
            System.out.println("password cannot be empty");
            return;
        }

        if (!oldPassword.equals(account.getPassword())) {
            System.out.println("wrong password");
            return;
        }

        String newPassword = readLine("enter new password (min 6 chars, must include letters and numbers): ");
        if (newPassword == null || newPassword.isEmpty()) {
            System.out.println("new password cannot be empty");
            return;
        }

        if (!isValidPassword(newPassword)) {
            System.out.println("password must be at least 6 characters and include both letters and numbers");
            return;
        }

        if (newPassword.equals(oldPassword)) {
            System.out.println("new password must be different from the current password");
            return;
        }

        boolean success = accountService.changePassword(account.getUsername(), oldPassword, newPassword);
        if (success) {
            System.out.println("password changed successfully");
        } else {
            System.out.println("failed to change password, please try again");
        }
    }

    // print all transactions recorded for this account
    private void showTransactions(Account account) {
        List<Transaction> transactions = account.getTransactions();
        if (transactions == null || transactions.isEmpty()) {
            System.out.println("no transactions yet");
            return;
        }

        System.out.println("\ntransaction history:");
        int index = 1;
        for (Transaction t : transactions) {
            System.out.println(index + ". " + t);
            index++;
        }
    }

    // delete the account permanently after the user types yes to confirm
    private boolean deleteAccount(Account account) {
        String confirm = readLine("type 'yes' to confirm deleting your account (cannot be undone): ");
        if (!"yes".equals(confirm)) {
            System.out.println("delete cancelled");
            return false;
        }

        boolean success = accountService.deleteAccount(account.getUsername());
        if (success) {
            System.out.println("account deleted");
            return true;
        } else {
            System.out.println("failed to delete account, please try again");
            return false;
        }
    }

    // mark the account as inactive after the user types yes to confirm
    private boolean deactivateAccount(Account account) {
        String confirm = readLine("type 'yes' to confirm deactivating your account: ");
        if (!"yes".equals(confirm)) {
            System.out.println("deactivation cancelled");
            return false;
        }

        boolean success = accountService.setAccountActive(account.getUsername(), false);
        if (success) {
            System.out.println("account deactivated, you are now logged out");
            return true;
        } else {
            System.out.println("failed to deactivate account, please try again");
            return false;
        }
    }

    // print a list of all accounts in the system for the admin
    private void viewAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        if (accounts == null || accounts.isEmpty()) {
            System.out.println("no accounts found");
            return;
        }

        System.out.println("\nall accounts:");
        int index = 1;
        for (Account acc : accounts) {
            if (acc != null) {
                System.out.println(index + ". " + acc.getUsername()
                        + " | phone: " + (acc.getPhoneNumber() != null ? acc.getPhoneNumber() : "n/a")
                        + " | balance: " + acc.getBalance() + " egp"
                        + " | status: " + (acc.isActive() ? "active" : "inactive")
                        + " | type: " + (acc.isAdmin() ? "admin" : "user"));
                index++;
            }
        }
    }

    // let the admin change the active or inactive status of any account
    private void manageAccountStatus() {
        String username = readLine("enter the username to manage: ");
        if (username == null || username.isEmpty()) {
            System.out.println("username cannot be empty");
            return;
        }

        Account target = accountService.findByUsername(username);
        if (target == null) {
            System.out.println("account not found");
            return;
        }

        System.out.println("current status: " + (target.isActive() ? "active" : "inactive"));
        System.out.println("1. activate");
        System.out.println("2. deactivate");

        int choice = readInt("choose: ");

        if (choice == 1) {
            accountService.setAccountActive(username, true);
            System.out.println("account activated");
        } else if (choice == 2) {
            accountService.setAccountActive(username, false);
            System.out.println("account deactivated");
        } else {
            System.out.println("invalid option");
        }
    }

    // check that the username has at least 3 chars and starts with an uppercase letter
    private boolean isValidUsername(String username) {
        if (username == null || username.length() < 3) {
            return false;
        }
        return Character.isUpperCase(username.charAt(0));
    }

    // check that the password has at least 6 chars with at least one letter and one digit
    private boolean isValidPassword(String password) {
        if (password == null || password.length() < 6) {
            return false;
        }
        boolean hasLetter = false;
        boolean hasDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) hasLetter = true;
            if (Character.isDigit(c)) hasDigit = true;
        }
        return hasLetter && hasDigit;
    }

    // check that the phone is 11 digits and follows one of the egypt mobile prefixes
    private boolean isValidPhone(String phone) {
        if (phone == null || phone.length() != 11) {
            return false;
        }
        for (char c : phone.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return phone.startsWith("010") || phone.startsWith("011")
                || phone.startsWith("012") || phone.startsWith("015");
    }

    // read a line of text from the user and trim whitespace, returns null on read failure
    private String readLine(String prompt) {
        System.out.print(prompt);
        try {
            return scanner.nextLine().trim();
        } catch (NoSuchElementException | IllegalStateException e) {
            System.err.println("unable to read input: " + e.getMessage());
            return null;
        }
    }

    // read a whole number from the user, returns -1 if the input is not a valid number
    private int readInt(String prompt) {
        String input = readLine(prompt);
        if (input == null || input.isEmpty()) {
            return -1;
        }
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ignored) {
            return -1;
        }
    }

    // read a decimal number from the user, returns -1 if the input is not valid
    private double readDouble(String prompt) {
        String input = readLine(prompt);
        if (input == null || input.isEmpty()) {
            return -1;
        }
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException ignored) {
            return -1;
        }
    }
}
