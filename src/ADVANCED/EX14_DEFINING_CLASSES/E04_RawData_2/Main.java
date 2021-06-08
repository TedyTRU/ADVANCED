package ADVANCED.EX14_DEFINING_CLASSES.E04_RawData_2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Car>> cars = new LinkedHashMap<>();

        while (n-- > 0) {
            fillMap(scanner, cars);
        }

        String type = scanner.nextLine();

        switch (type) {
            case "fragile":
                cars.get(type).stream()
                        .filter(pressure -> pressure.getTires().hasLowPressure())
                        .forEach(e -> System.out.println(e.getModel()));
                break;

            case "flamable":
                cars.get(type).stream()
                        .filter(power -> power.getEngine().hasHighPower())
                        .forEach(e -> System.out.println(e.getModel()));
                break;
        }

    }

    private static void fillMap(Scanner scanner, Map<String, List<Car>> cars) {
        String[] carInfo = scanner.nextLine().split("\\s+");

        String model = carInfo[0];
        int engineSpeed = Integer.parseInt(carInfo[1]);
        int enginePower = Integer.parseInt(carInfo[2]);
        int cargoWeight = Integer.parseInt(carInfo[3]);
        String cargoType = carInfo[4];
        double tire1Pressure = Double.parseDouble(carInfo[5]);
        int tire1Age = Integer.parseInt(carInfo[6]);
        double tire2Pressure = Double.parseDouble(carInfo[7]);
        int tire2Age = Integer.parseInt(carInfo[8]);
        double tire3Pressure = Double.parseDouble(carInfo[9]);
        int tire3Age = Integer.parseInt(carInfo[10]);
        double tire4Pressure = Double.parseDouble(carInfo[11]);
        int tire4Age = Integer.parseInt(carInfo[12]);

        cars.putIfAbsent(cargoType, new ArrayList<>());
        Engine engine = new Engine(engineSpeed, enginePower);
        Cargo cargo = new Cargo(cargoWeight, cargoType);
        Tires tires = new Tires(tire1Pressure, tire1Age, tire2Pressure, tire2Age,
                tire3Pressure, tire3Age, tire4Pressure, tire4Age);
        Car car = new Car(model, engine, cargo, tires);
        cars.get(cargoType).add(car);
    }
}
