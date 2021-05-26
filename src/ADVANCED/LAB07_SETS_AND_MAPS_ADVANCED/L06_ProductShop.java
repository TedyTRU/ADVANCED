package ADVANCED.LAB07_SETS_AND_MAPS_ADVANCED;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class L06_ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Double>> foodShops = new TreeMap<>();

        String line = scanner.nextLine();
        while (!"Revision".equals(line)) {
            String[] shop = line.split(", ");
            String shopName = shop[0];
            String product = shop[1];
            double price = Double.parseDouble(shop[2]);

            foodShops.putIfAbsent(shopName, new LinkedHashMap<>());
            foodShops.get(shopName).putIfAbsent(product, price);

            line = scanner.nextLine();
        }

        foodShops.forEach((key1, value1) -> {

            System.out.println(key1 + "->");
            value1.forEach((key, value) -> System.out.printf("Product: %s, Price: %.1f%n", key, value));
        });

    }
}
