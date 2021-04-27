package ADVANCED.LAB13_DEFINING_CLASSES.L03_BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Integer, BankAccount> vault = new HashMap<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");

            String output;

            switch (tokens[0]) {

                case "Deposit":
                    int id = Integer.parseInt(tokens[1]);
                    int amount = Integer.parseInt(tokens[2]);
                    vault.get(id).deposit(amount);
                    output = "Deposited " + amount + " to ID" + id;
                    break;

                case "GetInterest":
                    id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);
                    double interest = vault.get(id).getInterest(years);
                    output = String.format("%.2f", interest);
                    break;

                case "SetInterest":
                    double newInterest = Double.parseDouble(tokens[2]);
                    BankAccount.setInterestRate(newInterest);
                    output = null;
                    break;

                default:
                    BankAccount bankAccount = new BankAccount();
                    vault.put(bankAccount.getId(), bankAccount);
                    output = "Account ID " + bankAccount.getId() + "created";
                    break;

            }

            if (output != null) {
                System.out.println(output);
            }

            input = scanner.nextLine();
        }

    }
}
