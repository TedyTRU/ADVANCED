package ADVANCED.EX14_DEFINING_CLASSES.E05_CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        //List<Engine> engines = new ArrayList<>();
        Map<String, Engine> engineMap = new HashMap<>();

        while (n-- > 0) {
            Engine engine = null;
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);

            if (tokens.length == 2) {
                engine = new Engine(model, power);

            } else if (tokens.length == 4) {
                int displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];
                engine = new Engine(model, power, displacement, efficiency);

            } else if (tokens.length == 3) {

                if (tokens[2].matches("^\\d+$")) {
                    int displacement = Integer.parseInt(tokens[2]);
                    engine = new Engine(model, power, displacement);
                } else {
                    String efficiency = tokens[2];
                    engine = new Engine(model, power, efficiency);
                }
            }
            //engines.add(engine);
            engineMap.putIfAbsent(model, engine);
        }


        int m = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new LinkedList<>();

        while (m-- > 0) {
            Car car = null;
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            //String engineModel = tokens[1];
            Engine engineModel = engineMap.get(tokens[1]);

            if (tokens.length == 2) {
                car = new Car(model, engineModel);

            } else if (tokens.length == 4) {
                int weight = Integer.parseInt(tokens[2]);
                String colour = tokens[3];
                car = new Car(model, engineModel, weight, colour);

            } else if (tokens.length == 3) {
                if (tokens[2].matches("^\\d+$")) {
                    int weight = Integer.parseInt(tokens[2]);
                    car = new Car(model, engineModel, weight);
                } else {
                    String colour = tokens[2];
                    car = new Car(model, engineModel, colour);
                }
            }
            cars.add(car);
        }

        cars.forEach(car -> System.out.println(car));
    }
}
