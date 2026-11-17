package problem3;

import java.util.Vector;

public class Bank {
    private Vector<Account> accounts;

    public Bank() {
        accounts = new Vector<>();
    }

    public void openAccount(Account acc) {
        accounts.add(acc);
        System.out.println("Account " + acc.getAccountNumber() + " opened.");
    }

    public void closeAccount(int accNumber) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber() == accNumber) {
                accounts.remove(i);
                System.out.println("Account " + accNumber + " closed.");
                return;
            }
        }
        System.out.println("Account " + accNumber + " not found.");
    }

    public void update() {
        for (Account acc : accounts) {
            if (acc instanceof SavingsAccount) {
                ((SavingsAccount) acc).addInterest();
                System.out.println("Interest added to " + acc);
            } else if (acc instanceof CheckingAccount) {
                ((CheckingAccount) acc).deductFee();
                System.out.println("Fee checked for " + acc);
            } //врем обращ к чек акк
        }
    }

    public void printAllAccounts() {
        for (Account acc : accounts) {
            acc.print();
        }
    }
}
