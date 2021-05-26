package ADVANCED.LAB07_SETS_AND_MAPS_ADVANCED;

import java.util.*;
import java.util.stream.Collectors;

public class L07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, LinkedHashMap<String, List<String>>> cities = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] lines = scanner.nextLine().split("\\s+");
            String continent = lines[0];
            String country = lines[1];
            String city = lines[2];

            cities.putIfAbsent(continent, new LinkedHashMap<>());
            cities.get(continent).putIfAbsent(country, new ArrayList<>());
            cities.get(continent).get(country).add(city);

        }

        cities.forEach((key, value) -> {
            System.out.println(key + ":");
            value.entrySet()
                    .forEach(country -> {
                        System.out.print(String.format(" %s -> ", country.getKey()));
                        System.out.print(country.getValue().stream().collect(Collectors.joining(", ")));
                        System.out.println();
                    });
        });

    }
}
