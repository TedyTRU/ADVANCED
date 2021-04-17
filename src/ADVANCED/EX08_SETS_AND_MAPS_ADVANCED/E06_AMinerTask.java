package ADVANCED.EX08_SETS_AND_MAPS_ADVANCED;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E06_AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String resource = scanner.nextLine();
        Map<String, Integer> resources = new LinkedHashMap<>();

        while (!"stop".equals(resource)) {
            resources.putIfAbsent(resource, 0);
            int quantity = Integer.parseInt(scanner.nextLine());
            int currentQuantity = resources.get(resource);

            resources.put(resource, quantity + currentQuantity);

            resource = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
