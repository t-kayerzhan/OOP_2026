package problem3;

public class Account {
    private double balance;
    private int accNumber;

    public Account(int a) {
        balance = 0.0;
        accNumber = a;
    }

    public void deposit(double sum) {
        if (sum > 0)
            balance += sum;
        else
            System.out.println("must be positive.");
    }

    public void withdraw(double sum) {
        if (sum > 0 && balance >= sum)
            balance -= sum;
        else
            System.out.println("no ssuch balance .");
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accNumber;
    }

    public void transfer(double amount, Account other) {
        if (amount > 0 && balance >= amount) {
            this.withdraw(amount); 		//-
            other.deposit(amount);		//+
        } else {
            System.out.println("failed");
        }
    }

    public String toString() {
        return "Account " + accNumber + ": balance = $" + balance;
    }

    public final void print() {
        System.out.println(toString());
    }
}