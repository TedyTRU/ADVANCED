package ADVANCED.EX08_SETS_AND_MAPS_ADVANCED;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class E04_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Map<Character, Integer> countOfSymbols = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);

            //variant 1
            Integer counter = countOfSymbols.get(symbol);
            if (counter == null) {
                counter = 0;
            }
            countOfSymbols.put(symbol, counter + 1);

            //variant 4
//            int currentValue = countOfSymbols.getOrDefault(symbol, 0);
//            countOfSymbols.put(symbol, currentValue + 1);

        }

        for (Map.Entry<Character, Integer> entry : countOfSymbols.entrySet()) {
            System.out.printf("%c: %d time/s%n", entry.getKey(), entry.getValue());
        }

    }
}
