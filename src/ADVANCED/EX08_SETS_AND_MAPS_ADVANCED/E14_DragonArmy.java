package ADVANCED.EX08_SETS_AND_MAPS_ADVANCED;

import java.util.*;

public class E14_DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<Integer>>> typesOfDragons = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] dragonsInfo = scanner.nextLine().split("\\s+");
            String type = dragonsInfo[0];
            String name = dragonsInfo[1];
            int health = 250;
            int damage = 45;
            int armor = 10;

            if (!dragonsInfo[2].equals("null")) {
                damage = Integer.parseInt(dragonsInfo[2]);
            }
            if (!dragonsInfo[3].equals("null")) {
                health = Integer.parseInt(dragonsInfo[3]);
            }
            if (!dragonsInfo[4].equals("null")) {
                armor = Integer.parseInt(dragonsInfo[4]);
            }

            typesOfDragons.putIfAbsent(type, new TreeMap<>());
            List<Integer> values = Arrays.asList(damage, health, armor);
            typesOfDragons.get(type).put(name, values);

        }

        typesOfDragons.forEach((key1, value1) -> {
            double averageDamage = getAverage(value1, 0);
            double averageHealth = getAverage(value1, 1);
            double averageArmor = getAverage(value1, 2);

            System.out.println(String.format("%s::(%.2f/%.2f/%.2f)", key1, averageDamage, averageHealth, averageArmor));

            value1.forEach((key, value) -> System.out.println(String.format("-%s -> damage: %d, health: %d, armor: %d"
                    , key, value.get(0), value.get(1), value.get(2))));

        });

    }

    public static double getAverage(Map<String, List<Integer>> listMap, int i) {
        double sum = 0;

        for (Map.Entry<String, List<Integer>> entry : listMap.entrySet()) {
            sum += entry.getValue().get(i);
        }
        return sum / listMap.size();
    }

//    private static Double getAverage(Collection<List<Double>> values, int i) {
//        return values.stream().map(doubles -> doubles.get(i)).mapToDouble(Double::doubleValue).average().orElseThrow();
//    }

}
