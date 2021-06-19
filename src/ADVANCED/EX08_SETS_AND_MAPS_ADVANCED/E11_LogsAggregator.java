package ADVANCED.EX08_SETS_AND_MAPS_ADVANCED;

import java.util.*;
import java.util.stream.Collectors;

public class E11_LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> logsDuration = new TreeMap<>();
        Map<String, Set<String>> logsAggregator = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] logs = scanner.nextLine().split("\\s+");
            String ip = logs[0];
            String name = logs[1];
            int duration = Integer.parseInt(logs[2]);

            logsDuration.putIfAbsent(name, 0);
            int sumDuration = logsDuration.get(name) + duration;
            logsDuration.put(name, sumDuration);

            logsAggregator.putIfAbsent(name, new TreeSet<>());
            logsAggregator.get(name).add(ip);

        }

        logsDuration.forEach((key, value) -> System.out.printf("%s: %d [%s]%n", key, value,
                String.join(", ", logsAggregator.get(key))));

    }
}
