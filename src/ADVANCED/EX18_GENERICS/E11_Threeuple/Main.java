package ADVANCED.EX18_GENERICS.E11_Threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] tokens = sc.nextLine().split("\\s+");
        String name = String.format("%s %s", tokens[0], tokens[1]);
        String address = tokens[2];
        String city = tokens[3];
        Threeuple<String, String, String> personDetails = new Threeuple<>(name, address, city);
        System.out.println(personDetails);


        tokens = sc.nextLine().split("\\s+");
        name = tokens[0];
        int litres = Integer.parseInt(tokens[1]);
        boolean drunkOrNot = "drunk".equals(tokens[2]);
        Threeuple<String, Integer, Boolean> personLitres = new Threeuple<>(name, litres, drunkOrNot);
        System.out.println(personLitres);


        tokens = sc.nextLine().split("\\s+");
        name = tokens[0];
        double accountBalance = Double.parseDouble(tokens[1]);
        String bankName = tokens[2];
        Threeuple<String, Double, String> numbers = new Threeuple<>(name, accountBalance, bankName);
        System.out.println(numbers);


    }
}
