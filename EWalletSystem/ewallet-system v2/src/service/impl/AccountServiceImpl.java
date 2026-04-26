package service.impl;

import model.Account;
import model.EWalletSystem;
import model.Transaction;
import service.AccountService;

import java.util.List;
import java.util.Objects;

public class AccountServiceImpl implements AccountService {

    // single wallet instance that holds all accounts for the session
    private final EWalletSystem eWalletSystem = new EWalletSystem();

    // add the default admin account when the service is first created
    public AccountServiceImpl() {
        Account admin = new Account("yaseen", "yaseen123", true);
        eWalletSystem.getAccounts().add(admin);
    }

    @Override
    public boolean createAccount(Account account) {
        if (account == null || account.getUsername() == null) {
            return false;
        }

        try {
            List<Account> accounts = eWalletSystem.getAccounts();

            // reject the account if the username or phone number is already used
            boolean duplicate = accounts.stream()
                    .filter(Objects::nonNull)
                    .anyMatch(acc ->
                            Objects.equals(acc.getUsername(), account.getUsername()) ||
                            (account.getPhoneNumber() != null &&
                             Objects.equals(acc.getPhoneNumber(), account.getPhoneNumber()))
                    );

            if (duplicate) {
                return false;
            }

            account.addTransaction(new Transaction("signup", 0, "account created"));
            return accounts.add(account);

        } catch (RuntimeException e) {
            System.err.println("failed to create account: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Account login(String username, String password) {
        if (username == null || password == null) {
            return null;
        }

        try {
            Account account = eWalletSystem.getAccounts().stream()
                    .filter(Objects::nonNull)
                    .filter(acc -> Objects.equals(acc.getUsername(), username)
                            && Objects.equals(acc.getPassword(), password))
                    .findFirst()
                    .orElse(null);

            // record the login event in the account history if credentials matched
            if (account != null) {
                account.addTransaction(new Transaction("login", 0, "user logged in"));
            }

            return account;

        } catch (RuntimeException e) {
            System.err.println("failed to process login: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Account findByUsername(String username) {
        if (username == null) {
            return null;
        }

        try {
            return eWalletSystem.getAccounts().stream()
                    .filter(Objects::nonNull)
                    .filter(acc -> Objects.equals(acc.getUsername(), username))
                    .findFirst()
                    .orElse(null);
        } catch (RuntimeException e) {
            System.err.println("failed to find account by username: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Account findByPhone(String phone) {
        if (phone == null) {
            return null;
        }

        try {
            return eWalletSystem.getAccounts().stream()
                    .filter(Objects::nonNull)
                    .filter(acc -> acc.getPhoneNumber() != null
                            && Objects.equals(acc.getPhoneNumber(), phone))
                    .findFirst()
                    .orElse(null);
        } catch (RuntimeException e) {
            System.err.println("failed to find account by phone: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deposit(String username, double amount) {
        try {
            Account account = findByUsername(username);
            if (account == null) {
                return false;
            }

            account.setBalance(account.getBalance() + amount);
            account.addTransaction(new Transaction("deposit", amount, "deposited to account"));
            return true;

        } catch (RuntimeException e) {
            System.err.println("failed to deposit: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean withdraw(String username, double amount) {
        try {
            Account account = findByUsername(username);
            if (account == null) {
                return false;
            }

            if (account.getBalance() < amount) {
                return false;
            }

            account.setBalance(account.getBalance() - amount);
            account.addTransaction(new Transaction("withdraw", amount, "withdrawn from account"));
            return true;

        } catch (RuntimeException e) {
            System.err.println("failed to withdraw: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean transfer(String fromUsername, String toUsername, double amount) {
        try {
            Account sender = findByUsername(fromUsername);
            Account receiver = findByUsername(toUsername);

            if (sender == null || receiver == null) {
                return false;
            }

            if (sender.getBalance() < amount) {
                return false;
            }

            sender.setBalance(sender.getBalance() - amount);
            receiver.setBalance(receiver.getBalance() + amount);

            sender.addTransaction(new Transaction("transfer out", amount, "transferred to " + toUsername));
            receiver.addTransaction(new Transaction("transfer in", amount, "received from " + fromUsername));

            return true;

        } catch (RuntimeException e) {
            System.err.println("failed to transfer: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        try {
            Account account = findByUsername(username);
            if (account == null) {
                return false;
            }

            if (!Objects.equals(account.getPassword(), oldPassword)) {
                return false;
            }

            account.setPassword(newPassword);
            account.addTransaction(new Transaction("change password", 0, "password updated"));
            return true;

        } catch (RuntimeException e) {
            System.err.println("failed to change password: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteAccount(String username) {
        try {
            List<Account> accounts = eWalletSystem.getAccounts();
            return accounts.removeIf(acc -> acc != null
                    && Objects.equals(acc.getUsername(), username));
        } catch (RuntimeException e) {
            System.err.println("failed to delete account: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean setAccountActive(String username, boolean active) {
        try {
            Account account = findByUsername(username);
            if (account == null) {
                return false;
            }

            account.setActive(active);
            String note = active ? "account activated" : "account deactivated";
            account.addTransaction(new Transaction("status change", 0, note));
            return true;

        } catch (RuntimeException e) {
            System.err.println("failed to change account status: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Account> getAllAccounts() {
        return eWalletSystem.getAccounts();
    }
}
