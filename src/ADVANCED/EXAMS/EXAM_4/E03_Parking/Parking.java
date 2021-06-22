package ADVANCED.EXAMS.EXAM_4.E03_Parking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Parking {

    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.capacity > this.data.size()) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        return this.data.removeIf(e -> e.getManufacturer().equals(manufacturer) &&
                e.getModel().equals(model));
    }

    public Car getLatestCar() {
//        int maxYear = Integer.MIN_VALUE;
//        Car car = null;
//        for (Car datum : this.data) {
//            if (datum.getYear() > maxYear) {
//                maxYear = datum.getYear();
//                car = datum;
//            }
//        }
//        return car;

        return this.data.stream()
                .max((c1, c2) -> Integer.compare(c2.getYear(), c1.getYear()))
                .orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return this.data.stream()
                .filter(e -> e.getManufacturer().equals(manufacturer) && e.getModel().equals(model))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("The cars are parked in %s:%n", this.type));
        this.data.forEach(car -> sb.append(car).append(System.lineSeparator()));

        return sb.toString();
    }

}
