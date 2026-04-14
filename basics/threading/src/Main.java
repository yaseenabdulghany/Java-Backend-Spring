public class Main {

    static class MyThread extends Thread {
        public void run() {
            System.out.println("Hello from thread");
        }
    }

    static class MyRunnable implements Runnable {
        public void run() {
            System.out.println("Thread: " + Thread.currentThread().getName() + " - Hello from Runnable");
        }
    }

    static class BankAccount {
        private int balance = 0;

        public synchronized void deposit(int amount) {
            balance += amount;
            System.out.println("Deposited " + amount + " | Balance: " + balance);
            notify();
        }

        public synchronized void withdraw(int amount) throws InterruptedException {
            while (balance < amount) {
                System.out.println("Not enough balance, waiting...");
                wait();
            }
            balance -= amount;
            System.out.println("Withdrew " + amount + " | Balance: " + balance);
        }
    }

    static class Depositor extends Thread {
        private BankAccount account;

        public Depositor(BankAccount account) {
            this.account = account;
        }

        public void run() {
            try {
                for (int i = 0; i < 5; i++) {
                    account.deposit(200);
                    Thread.sleep(1500);
                }
            } catch (InterruptedException e) {}
        }
    }

    static class Withdrawer extends Thread {
        private BankAccount account;

        public Withdrawer(BankAccount account) {
            this.account = account;
        }

        public void run() {
            try {
                for (int i = 0; i < 5; i++) {
                    account.withdraw(150);
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {}
        }
    }


    public static void main(String[] args) throws InterruptedException {

        System.out.println("=== 1. Extends Thread ===");
        MyThread t1 = new MyThread();
        t1.start();
        t1.join();

        System.out.println("\n=== 2. Implements Runnable ===");
        Thread t2 = new Thread(new MyRunnable());
        t2.start();
        t2.join();

        System.out.println("\n=== 3. Thread Sleep ===");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
            Thread.sleep(1000);
        }

        System.out.println("\n=== 4. Thread Join ===");
        Thread ta = new Thread(() -> System.out.println("Thread 1 done"));
        Thread tb = new Thread(() -> System.out.println("Thread 2 done"));
        ta.start();
        tb.start();
        ta.join();
        tb.join();
        System.out.println("Main thread done");

        System.out.println("\n=== 5. Bank Account (wait & notify) ===");
        BankAccount account = new BankAccount();
        Depositor depositor = new Depositor(account);
        Withdrawer withdrawer = new Withdrawer(account);
        depositor.start();
        withdrawer.start();
        depositor.join();
        withdrawer.join();
    }
}