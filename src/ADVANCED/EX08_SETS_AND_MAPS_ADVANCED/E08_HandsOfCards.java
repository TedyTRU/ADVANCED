package ADVANCED.EX08_SETS_AND_MAPS_ADVANCED;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E08_HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, Set<String>> players = new LinkedHashMap<>();

        while (!"JOKER".equals(line)) {
            String name = line.split(": ")[0];
            String[] cards = line.split(": ")[1].split(", ");

            if (!players.containsKey(name)) {
                players.put(name, new HashSet<>());
            }

//            for (String card: cards) {
//                players.get(name).add(card.trim());
//            }

            players.get(name).addAll(Arrays.asList(cards));

            line = scanner.nextLine();
        }

        String regex = "(?<power>[0-9]+|[JQKA])(?<type>[CHDS]{1})";
        Pattern pattern = Pattern.compile(regex);

        Map<String, Integer> multipliersByType = new HashMap<>();
        multipliersByType.put("S", 4);
        multipliersByType.put("H", 3);
        multipliersByType.put("D", 2);
        multipliersByType.put("C", 1);

        for (Map.Entry<String, Set<String>> entry : players.entrySet()) {
            int scores = 0;

            for (String card : entry.getValue()) {
                Matcher matcher = pattern.matcher(card);
                if (matcher.find()) {
                    String power = matcher.group("power");
                    String type = matcher.group("type");

                    int value = getValuePower(power);
                    int multiplier = multipliersByType.get(type);

                    scores += value * multiplier;
                }
            }
            System.out.printf("%s: %d%n", entry.getKey(), scores);
        }

    }

    private static int getValuePower(String power) {
        int value = 0;
        switch (power) {
            case "J":
                value = 11;
                break;
            case "Q":
                value = 12;
                break;
            case "K":
                value = 13;
                break;
            case "A":
                value = 14;
                break;
            default:
                value = Integer.parseInt(power);
                break;
        }
        return value;
    }
}
