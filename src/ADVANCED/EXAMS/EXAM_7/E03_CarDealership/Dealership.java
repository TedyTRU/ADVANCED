package ADVANCED.EXAMS.EXAM_7.E03_CarDealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {


    private List<Car> data;
    private String name;
    private int capacity;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public List<Car> getData() {
        return data;
    }

    public void add(Car car) {
        if (capacity > this.data.size()) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        return this.data.removeIf(e -> e.getManufacturer().equals(manufacturer)
                && e.getModel().equals(model));
    }

    public Car getLatestCar() {
        return this.data.stream().min((e2, e1) -> Integer.compare(e1.getYear(), e2.getYear())).orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return this.data.stream().filter(e -> e.getManufacturer().equals(manufacturer) &&
                e.getModel().equals(model)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are in a car dealership %s:%n", this.name));
        this.data.forEach(e -> sb.append(e).append(System.lineSeparator()));

        return sb.toString();
    }

}
