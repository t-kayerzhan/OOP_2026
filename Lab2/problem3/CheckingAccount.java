package problem3;

public class CheckingAccount extends Account {
    private static final int FREE_TRANSACTIONS = 3;
    private int transactionCount;

    public CheckingAccount(int accNumber) {
        super(accNumber);
        transactionCount = 0;
    }

    @Override
    public void deposit(double sum) {
        super.deposit(sum);
        transactionCount++;
    }

    @Override
    public void withdraw(double sum) {
        super.withdraw(sum);
        transactionCount++;
    }

    public void deductFee() {
        if (transactionCount > FREE_TRANSACTIONS) {
            double fee = (transactionCount - FREE_TRANSACTIONS) * 0.02;
            if (getBalance() >= fee) {
                super.withdraw(fee);
                System.out.println("Fee of $" + fee + " deduct.");
            } else {
                System.out.println("no balance to pay fee.");
            }
        }
        
        transactionCount = 0;
    }

    @Override
    public String toString() {
        return "CheckingAccount " + getAccountNumber() + ": balance = $" + getBalance() +
               ", amout of transactions = " + transactionCount;
    }
}
