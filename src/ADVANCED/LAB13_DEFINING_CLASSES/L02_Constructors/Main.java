package ADVANCED.LAB13_DEFINING_CLASSES.L02_Constructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String brand = tokens[0];

            Car car;

            if (tokens.length == 3) {
                String model = tokens[1];
                int horsePower = Integer.parseInt(tokens[2]);

                car = new Car(brand, model, horsePower);

            } else {
                car = new Car(brand);

            }

            cars.add(car);
        }

        for (Car car : cars) {
            System.out.printf("The car is: %s %s - %d HP.%n",
                    car.getBrand(), car.getModel(), car.getHorsePower());
        }

    }
}
