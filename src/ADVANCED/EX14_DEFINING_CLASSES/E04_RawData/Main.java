package ADVANCED.EX14_DEFINING_CLASSES.E04_RawData;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Car> cars = new LinkedHashMap<>();

        while (n-- > 0) {

            String[] data = scanner.nextLine().split("\\s+");
            String carModel = data[0];
            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);
            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];
            double tire1Pressure = Double.parseDouble(data[5]);
            int tire1Age = Integer.parseInt(data[6]);
            double tire2Pressure = Double.parseDouble(data[7]);
            int tire2Age = Integer.parseInt(data[8]);
            double tire3Pressure = Double.parseDouble(data[9]);
            int tire3Age = Integer.parseInt(data[10]);
            double tire4Pressure = Double.parseDouble(data[11]);
            int tire4Age = Integer.parseInt(data[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire tire = new Tire(tire1Pressure, tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);
            Car car = new Car(carModel, engine, cargo, tire);

            cars.putIfAbsent(carModel, car);

        }
        String command = scanner.nextLine();

        if (command.equals("flamable")) {

            for (Map.Entry<String, Car> entry : cars.entrySet()) {
                if (entry.getValue().getCargo().getType().equals("flamable") &&
                        entry.getValue().getEngine().getPower() > 250) {
                    System.out.println(entry.getKey());
                }
            }

        } else if (command.equals("fragile")) {

            for (Map.Entry<String, Car> entry : cars.entrySet()) {
                if (entry.getValue().getCargo().getType().equals("fragile") &&
                        entry.getValue().getTire().hasLowPressure()) {
                    //entry.getValue().getTire().getAveragePressure() < 1.0) {
                    System.out.println(entry.getKey());
                }
            }
        }
    }
}
