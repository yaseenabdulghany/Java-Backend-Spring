package service;

import model.Account;

public interface AccountService {
    // Create a new account when the username is still available.
    Boolean createAccount(Account account);

    // Check if the provided login credentials already exist.
    Boolean isAccountExistByUserNameAndPassword(Account account);
}
