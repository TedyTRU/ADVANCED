package ADVANCED.EX08_SETS_AND_MAPS_ADVANCED;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E13_Unleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "(?<singer>[a-z A-Z]+) @(?<venue>[a-z A-Z]+) (?<ticketPrice>[0-9]+) (?<ticketsCount>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);

        Map<String, Map<String, Integer>> venues = new LinkedHashMap<>();

        String line = scanner.nextLine();

        while (!"End".equals(line)) {
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                String singer = matcher.group("singer").trim();
                String venue = matcher.group("venue").trim();
                int ticketPrice = Integer.parseInt(matcher.group("ticketPrice").trim());
                int ticketsCount = Integer.parseInt(matcher.group("ticketsCount").trim());

                int sum = ticketPrice * ticketsCount;

                venues.putIfAbsent(venue, new LinkedHashMap<>());
                venues.get(venue).putIfAbsent(singer, 0);
                sum += venues.get(venue).get(singer);
                venues.get(venue).put(singer, sum);

            }

            line = scanner.nextLine();
        }

        venues.forEach((key, value) -> {
            System.out.println(key);
            value.entrySet().stream().sorted((e2, e1) -> e1.getValue().compareTo(e2.getValue()))
                    .forEach(entry -> System.out.println(String.format("#  %s -> %d", entry.getKey(), entry.getValue())));
        });

    }
}
