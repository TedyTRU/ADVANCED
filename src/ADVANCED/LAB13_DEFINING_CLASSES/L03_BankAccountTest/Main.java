package ADVANCED.LAB13_DEFINING_CLASSES.L03_BankAccountTest;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            BankAccount bankAccount = new BankAccount();
            System.out.println(bankAccount.getId());
        }

    }
}
