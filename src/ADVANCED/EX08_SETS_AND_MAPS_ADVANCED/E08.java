package ADVANCED.EX08_SETS_AND_MAPS_ADVANCED;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, Set<String>> playersDecks = new LinkedHashMap<>();

        while (!"JOKER".equals(line)) {
            String name = line.split(":")[0];
            String[] deck = line.split(":")[1].trim().split(", ");

            if (!playersDecks.containsKey(name)) {
                playersDecks.put(name, new HashSet<>());
            }
            playersDecks.get(name).addAll(Arrays.asList(deck));

            line = scanner.nextLine();
        }

        playersDecks.forEach((key, value) -> System.out.printf("%s: %d%n", key, calculateCards(value)));

    }

    private static int calculateCards(Set<String> cards) {
        String regex = "([0-9]+|[JQKA])([SHDC]{1})";
        Pattern pattern = Pattern.compile(regex);

        Map<String, Integer> valuesOfType = new HashMap<>();
        valuesOfType.put("S", 4);
        valuesOfType.put("H", 3);
        valuesOfType.put("D", 2);
        valuesOfType.put("C", 1);

        int scores = 0;
        for (String card : cards) {
            Matcher matcher = pattern.matcher(card);

            if (matcher.find()) {
                String power = matcher.group(1);
                String type = matcher.group(2);

                int num1 = valuesOfType.get(type);
                int num2 = getValue(power);
                scores += num1 * num2;
            }
        }
        return scores;
    }

    private static int getValue(String power) {
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
