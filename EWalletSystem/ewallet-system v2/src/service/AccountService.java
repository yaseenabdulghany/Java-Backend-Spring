package service;

import model.Account;
import java.util.List;

public interface AccountService {

    // create a new account if the username and phone are not already taken
    boolean createAccount(Account account);

    // find the account that matches both username and password, return null if not found
    Account login(String username, String password);

    // find an account by username only
    Account findByUsername(String username);

    // find an account by phone number only
    Account findByPhone(String phone);

    // add money to the account balance
    boolean deposit(String username, double amount);

    // remove money from the account if there is enough balance
    boolean withdraw(String username, double amount);

    // send money from one account to another
    boolean transfer(String fromUsername, String toUsername, double amount);

    // update the password after verifying the old one matches
    boolean changePassword(String username, String oldPassword, String newPassword);

    // remove an account from the system permanently
    boolean deleteAccount(String username);

    // set whether an account is active or inactive
    boolean setAccountActive(String username, boolean active);

    // return the full list of all accounts in the system
    List<Account> getAllAccounts();
}
