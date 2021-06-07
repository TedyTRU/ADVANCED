package ADVANCED.LAB13_DEFINING_CLASSES.L03_BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<Integer, BankAccount> accountsMap = new HashMap<>();

        String output = null;

        while (!"End".equals(line)) {

            if (line.equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                accountsMap.put(bankAccount.getId(), bankAccount);
                output = String.format("Account ID%d created", bankAccount.getId());

            } else if (line.contains("Deposit")) {
                int id = Integer.parseInt(line.split("\\s+")[1]);
                int amount = Integer.parseInt(line.split("\\s+")[2]);
                BankAccount bankAccount = accountsMap.get(id);
                output = executeIfNotNull(bankAccount, b -> {
                    b.deposit(amount);
                    return String.format("Deposited %d to ID%d", amount, id);
                });

            } else if (line.contains("SetInterest")) {
                double interest = Double.parseDouble(line.split("\\s+")[1]);
                BankAccount.setInterestRate(interest);
                output = null;

            } else if (line.contains("GetInterest")) {
                int id = Integer.parseInt(line.split("\\s+")[1]);
                int years = Integer.parseInt(line.split("\\s+")[2]);

                BankAccount bankAccount = accountsMap.get(id);

                output = executeIfNotNull(bankAccount, b -> {
                    double interest = b.getInterest(years);
                    return String.format("%.2f", interest);
                });

            }

            if (output != null) {
                System.out.println(output);
            }

            line = scanner.nextLine();
        }

    }

    public static String executeIfNotNull(BankAccount account,
                                          Function<BankAccount, String> function) {

        if (account == null) {
            return "Account does not exist";
        }
        return function.apply(account);
    }
}
