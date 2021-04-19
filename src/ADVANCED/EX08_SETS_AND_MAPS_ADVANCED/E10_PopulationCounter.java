package ADVANCED.EX08_SETS_AND_MAPS_ADVANCED;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E10_PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String info = scanner.nextLine();
        Map<String, Map<String, Long>> populationCenter = new LinkedHashMap<>();

        while (!"report".equals(info)) {
            String[] infoArr = info.split("\\|");
            String city = infoArr[0];
            String country = infoArr[1];
            long population = Long.parseLong(infoArr[2]);

            populationCenter.putIfAbsent(country, new LinkedHashMap<>());
            populationCenter.get(country).putIfAbsent(city, population);

            info = scanner.nextLine();
        }

        populationCenter.entrySet().stream()
                .sorted((e1, e2) -> {
                    long p1 = e1.getValue().values().stream().mapToLong(e -> e).sum();
                    long p2 = e2.getValue().values().stream().mapToLong(e -> e).sum();
                    return Long.compare(p2, p1);
                }).forEach(c -> {
            long totalPopulation = c.getValue().values().stream().mapToLong(e -> e).sum();
            System.out.printf("%s (total population: %d)%n", c.getKey(), totalPopulation);

            Map<String, Long> cityInfo = c.getValue();
            cityInfo.entrySet().stream().sorted((c1, c2) -> Long.compare(c2.getValue(), c1.getValue()))
                    .forEach(city -> System.out.printf("=>%s: %d%n", city.getKey(), city.getValue()));
        });

    }
}
