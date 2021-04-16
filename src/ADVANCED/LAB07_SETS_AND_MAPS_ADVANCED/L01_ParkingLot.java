package ADVANCED.LAB07_SETS_AND_MAPS_ADVANCED;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class L01_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parking = new LinkedHashSet<>();
        String input = scanner.nextLine();

        while (!"END".equals(input)) {
            String carRegNum = input.split(", ")[1];
            //String carRegNum = input.substring(input.indexOf(", ") + 2);

            if (input.contains("IN")) {
                parking.add(carRegNum);

            } else if (input.contains("OUT")) {
                parking.remove(carRegNum);

            }
            input = scanner.nextLine();
        }

        String output = parking.stream()
                .collect(Collectors.joining(System.lineSeparator()));

        if (parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            System.out.println(output);
        }

    }
}
