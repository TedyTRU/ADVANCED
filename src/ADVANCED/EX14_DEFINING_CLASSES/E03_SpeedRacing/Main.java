package ADVANCED.EX14_DEFINING_CLASSES.E03_SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Car> modelCars = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            String model = carInfo[0];
            double fuelAmount = Double.parseDouble(carInfo[1]);
            double fuelCost = Double.parseDouble(carInfo[2]);

            modelCars.putIfAbsent(model, new Car(model, fuelAmount, fuelCost));
        }

        String command = scanner.nextLine();
        while (!"End".equals(command)) {
            String[] commands = command.split("\\s+");
            String model = commands[1];
            int amountOfKm = Integer.parseInt(commands[2]);

            if (modelCars.get(model).canMove(amountOfKm)) {
                modelCars.get(model).moveCar(amountOfKm);
            } else {
                System.out.println("Insufficient fuel for the drive");
            }

            command = scanner.nextLine();
        }
        for (Map.Entry<String, Car> carEntry : modelCars.entrySet()) {
            System.out.println(carEntry.getValue());
        }

    }
}
