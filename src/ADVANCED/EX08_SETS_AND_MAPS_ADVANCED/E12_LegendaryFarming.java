package ADVANCED.EX08_SETS_AND_MAPS_ADVANCED;

import java.util.*;

public class E12_LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> keyMaterials = new TreeMap<>();
        filKeyMaterials(keyMaterials);
        Map<String, Integer> junk = new TreeMap<>();

        boolean isObtained = false;
        String mat = "";

        while (!isObtained) {
            String[] line = scanner.nextLine().split("\\s+");

            for (int i = 0; i < line.length; i += 2) {
                int quantity = Integer.parseInt(line[i]);
                String material = line[i + 1].toLowerCase();

                if (material.equals("shards")
                        || material.equals("fragments")
                        || material.equals("motes")) {

                    int sumQuantity = keyMaterials.get(material) + quantity;
                    keyMaterials.put(material, sumQuantity);

                    if (sumQuantity >= 250) {
                        sumQuantity -= 250;
                        keyMaterials.put(material, sumQuantity);
                        mat = material;
                        isObtained = true;
                        break;
                    }

                } else {
                    junk.putIfAbsent(material, 0);
                    int sumQuantity = junk.get(material) + quantity;
                    junk.put(material, sumQuantity);
                }

            }
        }

        printWiner(mat);

        keyMaterials.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                //.sorted(Map.Entry.comparingByValue()).
                .forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));

        junk.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));

    }

    private static void filKeyMaterials(Map<String, Integer> keyMaterials) {
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
    }

    private static void printWiner(String mat) {
        switch (mat) {
            case "shards":
                System.out.println("Shadowmourne obtained!");
                break;
            case "fragments":
                System.out.println("Valanyr obtained!");
                break;
            case "motes":
                System.out.println("Dragonwrath obtained!");
                break;
        }
    }
}
