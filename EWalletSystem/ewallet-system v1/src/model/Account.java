package model;

public class Account {

    // Store the basic account details used by the application.
    private String username , password , phoneNumber;
    private Double balance ;
    private float age ;

    public Account() {

    }

    public Account(String username, String password) {
        // Build a lightweight account object for login checks.
        this.username = username;
        this.password = password;
    }

    public Account(String username, String password, String phoneNumber, float age) {
        // Initialize a new account with a default zero balance.
        this.username = username;
        this.password = password;
        this.balance = 0.0;
        this.phoneNumber = phoneNumber;
        this.age = age;
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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }
}
