package service.impl;

import model.Account;
import model.EWalletSystem;
import service.AccountService;

import java.util.List;
import java.util.Objects;

public class AccountServiceImpl implements AccountService {
    // Keep application accounts in memory through the service lifetime.
    private final EWalletSystem eWalletSystem = new EWalletSystem();

    @Override
    public Boolean createAccount(Account account) {
        if (account == null || account.getUsername() == null) {
            return false;
        }

        try {
            List<Account> accounts = eWalletSystem.getAccounts();
            if (accounts == null) {
                return false;
            }

            // Check username uniqueness before storing the account.
            boolean isAccountExist = accounts.stream()
                    .filter(Objects::nonNull)
                    .anyMatch(acc -> Objects.equals(acc.getUsername(), account.getUsername()));

            if (isAccountExist) {
                return false;
            }

            return accounts.add(account);
        } catch (RuntimeException exception) {
            // Keep unexpected service failures from crashing the caller.
            System.err.println("Failed to create account: " + exception.getMessage());
            return false;
        }
    }

    @Override
    public Boolean isAccountExistByUserNameAndPassword(Account account) {
        if (account == null) {
            return false;
        }

        try {
            List<Account> accounts = eWalletSystem.getAccounts();
            if (accounts == null) {
                return false;
            }

            // Match the requested username and password against saved accounts.
            return accounts.stream()
                    .filter(Objects::nonNull)
                    .anyMatch(acc -> Objects.equals(acc.getUsername(), account.getUsername())
                            && Objects.equals(acc.getPassword(), account.getPassword()));
        } catch (RuntimeException exception) {
            // Keep unexpected service failures from crashing the caller.
            System.err.println("Failed to validate account credentials: " + exception.getMessage());
            return false;
        }
    }

}
