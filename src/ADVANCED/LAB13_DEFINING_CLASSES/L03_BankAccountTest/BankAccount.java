package ADVANCED.LAB13_DEFINING_CLASSES.L03_BankAccountTest;

public class BankAccount {

    private static int accountCount = 1;
    private static double interestRate = 0.02;

    private int id;

    public BankAccount() {
        this.id = accountCount;
        accountCount++;
    }

    public int getId() {
        return id;
    }
}
