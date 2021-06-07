package ADVANCED.LAB13_DEFINING_CLASSES.L03_BankAccount;

public class BankAccount {

    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int bankAccountCount = 1;
    private int id;
    private int balance;

    public BankAccount() {
        this.id = bankAccountCount;
        bankAccountCount++;
    }

    public int getId() {
        return id;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    double getInterest(int years) {
        return BankAccount.interestRate * years * this.balance;
    }

    void deposit(double amount) {
        this.balance += amount;
    }

}
