package ADVANCED.EX14_DEFINING_CLASSES.E05_CarSalesman_2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Engine> engines = new HashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            fillEngine(scanner, engines);
        }

        List<Car> cars = new LinkedList<>();
        int m = Integer.parseInt(scanner.nextLine());

        while (m-- > 0) {
            fillCar(scanner, engines, cars);
        }

        for (Car car : cars) {
            System.out.println(car.toString());
        }

    }

    private static void fillCar(Scanner scanner, Map<String, Engine> engines, List<Car> cars) {
        String[] carInfo = scanner.nextLine().split("\\s+");
        String carModel = carInfo[0];
        String engineModel = carInfo[1];
        Car car = null;

        if (carInfo.length == 2) {
            car = new Car(carModel, engines.get(engineModel));

        } else if (carInfo.length == 4) {
            int weight = Integer.parseInt(carInfo[2]);
            String color = carInfo[3];
            car = new Car(carModel, engines.get(engineModel), weight, color);

        } else if (carInfo.length == 3) {
            if (carInfo[2].matches("^\\d+$")) {
                int weight = Integer.parseInt(carInfo[2]);
                car = new Car(carModel, engines.get(engineModel), weight);

            } else {
                String color = carInfo[2];
                car = new Car(carModel, engines.get(engineModel), color);

            }
        }
        cars.add(car);
    }

    private static void fillEngine(Scanner scanner, Map<String, Engine> engines) {
        String[] engineInfo = scanner.nextLine().split("\\s+");
        String model = engineInfo[0];
        int power = Integer.parseInt(engineInfo[1]);
        Engine engine = null;

        if (engineInfo.length == 4) {
            int displacement = Integer.parseInt(engineInfo[2]);
            String efficiency = engineInfo[3];
            engine = new Engine(model, power, displacement, efficiency);

        } else if (engineInfo.length == 2) {
            engine = new Engine(model, power);

        } else if (engineInfo.length == 3) {
            if (Character.isLetter(engineInfo[2].charAt(0))) {
                String efficiency = engineInfo[2];
                engine = new Engine(model, power, efficiency);

            } else {
                int displacement = Integer.parseInt(engineInfo[2]);
                engine = new Engine(model, power, displacement);
            }
        }
        engines.putIfAbsent(model, engine);
    }
}
