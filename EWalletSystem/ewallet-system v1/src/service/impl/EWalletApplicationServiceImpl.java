package service.impl;
import model.Account;
import service.AccountService;
import service.ApplicationService;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class EWalletApplicationServiceImpl implements ApplicationService {

    private final AccountService accountService = new AccountServiceImpl();
    // Reuse one scanner instance for the full console session.
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void start() {
        System.out.println("hello welcome :)");

        int counter = 0;
        boolean exit = false;

        while (true) {

            System.out.println("pls enter what you need to do?");
            System.out.println("1.login    2.signup    3.exit");

            try {
                int choose = scanner.nextInt();

                switch (choose) {

                    case 1:
                        // Run the login flow for an existing user.
                        login();
                        break;

                    case 2:
                        // Run the signup flow for a new user.
                        signup();
                        break;

                    case 3:
                        System.out.println("have a nice day :)");
                        exit = true;
                        break;

                    default:
                        System.out.println("invalid choose :(");
                        counter++;
                }
            } catch (InputMismatchException exception) {
                // Clear the invalid token before the next loop iteration.
                consumeInvalidToken();
                System.out.println("invalid choose :(");
                counter++;
            } catch (NoSuchElementException | IllegalStateException exception) {
                // Stop the application when console input is no longer available.
                System.err.println("Unable to read menu choice: " + exception.getMessage());
                break;
            }

            if (exit) {
                break;
            }

            if (counter == 4) {
                System.out.println("many invalid times pls contact with admin :((");
                break;
            }
        }
    }

    private void signup() {
        try {
            String userName = readNextValue("pls enter username.", "username");
            String password = readNextValue("pls enter password.", "password");
            String phoneNumber = readNextValue("pls enter phone number.", "phone number");
            Float age = readAge();

            if (userName == null || password == null || phoneNumber == null || age == null) {
                return;
            }

            // Create the account request from the entered signup data.
            Account account = new Account(userName, password, phoneNumber, age);
            boolean isAccountCreated = accountService.createAccount(account);
            if (isAccountCreated) {
                System.out.println("Account created successfully");
                mainProfile();
            } else {
                System.out.println("Account already exists with same username");
            }
        } catch (RuntimeException exception) {
            // Prevent unexpected signup failures from breaking the main loop.
            System.err.println("Signup failed: " + exception.getMessage());
        }
    }

    private void login() {
        try {
            String userName = readNextValue("pls enter username.", "username");
            String password = readNextValue("pls enter password.", "password");

            if (userName == null || password == null) {
                return;
            }

            // Build the login request from the entered credentials.
            Account account = new Account(userName, password);
            boolean isAccountExist = accountService.isAccountExistByUserNameAndPassword(account);

            if (isAccountExist) {
                mainProfile();
            } else {
                System.out.println("account does not exist");
            }
        } catch (RuntimeException exception) {
            // Prevent unexpected login failures from breaking the main loop.
            System.err.println("Login failed: " + exception.getMessage());
        }
    }

    private String readNextValue(String prompt, String fieldName) {
        System.out.println(prompt);

        try {
            return scanner.next();
        } catch (NoSuchElementException | IllegalStateException exception) {
            // Stop the current flow if the required text input cannot be read.
            System.err.println("Unable to read " + fieldName + ": " + exception.getMessage());
            return null;
        }
    }

    private Float readAge() {
        System.out.println("pls enter age.");

        try {
            return scanner.nextFloat();
        } catch (InputMismatchException exception) {
            // Clear the invalid token before returning to the caller.
            consumeInvalidToken();
            System.out.println("invalid age");
            return null;
        } catch (NoSuchElementException | IllegalStateException exception) {
            // Stop the current flow if the age input cannot be read.
            System.err.println("Unable to read age: " + exception.getMessage());
            return null;
        }
    }

    private void consumeInvalidToken() {
        try {
            // Consume the invalid token to keep the scanner usable.
            scanner.next();
        } catch (NoSuchElementException | IllegalStateException exception) {
            // Ignore token cleanup when input is no longer available.
            System.err.println("Unable to clear invalid input: " + exception.getMessage());
        }
    }

    private void mainProfile() {
        // Show the main profile options after successful authentication.
        System.out.println("1.deposit    2.withdraw    3.logout");
    }
}
