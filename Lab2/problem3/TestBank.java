package problem3;

public class TestBank {
    public static void main(String[] args) {
        Bank bank = new Bank();

        SavingsAccount savings = new SavingsAccount(1001, 0.03);
        CheckingAccount checking = new CheckingAccount(2001);
        Account basic = new Account(3001);

 
        bank.openAccount(savings);
        bank.openAccount(checking);
        bank.openAccount(basic);

        savings.deposit(1000);
        checking.deposit(500);
        checking.withdraw(50);
        checking.deposit(200);
        checking.withdraw(30); // now 4 th trans
        basic.deposit(700);

        System.out.println("\nBefore update:");
        bank.printAllAccounts();

        bank.update();

        System.out.println("\nAfter update:");
        bank.printAllAccounts();

    
        bank.closeAccount(3001);
        bank.printAllAccounts();
    }
}