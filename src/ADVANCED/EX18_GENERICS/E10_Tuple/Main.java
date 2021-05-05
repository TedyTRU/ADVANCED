package ADVANCED.EX18_GENERICS.E10_Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] tokens = sc.nextLine().split("\\s+");
        String name = String.format("%s %s", tokens[0], tokens[1]);
        String city = tokens[2];
        Tuple<String, String> personDetails = new Tuple<>(name, city);
        System.out.println(personDetails);


        tokens = sc.nextLine().split("\\s+");
        name = tokens[0];
        int litres = Integer.parseInt(tokens[1]);
        Tuple<String, Integer> personLitres = new Tuple<>(name, litres);
        System.out.println(personLitres);


        tokens = sc.nextLine().split("\\s+");
        int intNum = Integer.parseInt(tokens[0]);
        double doubleNum = Double.parseDouble(tokens[1]);
        Tuple<Integer, Double> numbers = new Tuple<>(intNum, doubleNum);
        System.out.println(numbers);


    }
}
