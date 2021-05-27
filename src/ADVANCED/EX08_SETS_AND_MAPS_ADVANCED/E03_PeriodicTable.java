package ADVANCED.EX08_SETS_AND_MAPS_ADVANCED;

import java.util.*;

public class E03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> chemicalElements = new HashSet<>();

        while (n-- > 0) {
            String[] line = scanner.nextLine().split("\\s+");

            chemicalElements.addAll(Arrays.asList(line));

        }

        chemicalElements.stream()
                .sorted()
                .forEach(element -> System.out.print(element + " "));

    }
}
