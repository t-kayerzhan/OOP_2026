package problem3;

public class SavingsAccount extends Account {
    private double interestRate; //  f.e 0.05 for 5%

    public SavingsAccount(int accNumber, double interestRate) {
        super(accNumber);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
    }

    @Override
    public String toString() {
        return "SavingsAccount " + getAccountNumber() + ": balance = $" + getBalance() +
               ", interest rate = " + (interestRate * 100) + "%";
    }
}
