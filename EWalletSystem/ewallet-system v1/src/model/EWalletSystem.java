package model;
import java.util.*;
public class EWalletSystem {
    private final String name = "Yaseen EWallet";
    // Keep all registered accounts in memory for the current run.
    private List<Account> accounts = new ArrayList<>();

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        // Keep the accounts list available to avoid null access in services.
        this.accounts = accounts == null ? new ArrayList<>() : accounts;
    }

    public String getName() {
        return name;
    }
}
