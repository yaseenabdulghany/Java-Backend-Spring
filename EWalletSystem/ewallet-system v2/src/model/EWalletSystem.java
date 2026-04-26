package model;

import java.util.ArrayList;
import java.util.List;

public class EWalletSystem {

    private final String name = "Yaseen EWallet";
    // keep all registered accounts in memory during the session
    private List<Account> accounts = new ArrayList<>();

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts == null ? new ArrayList<>() : accounts;
    }

    public String getName() {
        return name;
    }
}
