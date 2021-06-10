package ADVANCED.EXAMS.EXAM_1.E03_HealthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Salad {

    private String name;
    private List<Vegetable> products;

    public Salad(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getTotalCalories() {

        return this.products.stream().mapToInt(Vegetable::getCalories).sum();

//        int sum = 0;
//        for (Vegetable product : this.vegetable) {
//            sum += product.getCalories();
//        }
//        return sum;
    }

    public int getProductCount() {
        return this.products.size();
    }

    public void add(Vegetable product) {
        this.products.add(product);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("* Salad %s is %d calories and have %d products:"
                , getName(), this.getTotalCalories(), this.getProductCount()))
        .append(System.lineSeparator());

        this.products.forEach(product -> sb.append(product).append(System.lineSeparator()));

//        for (Vegetable product : this.vegetable) {
//            sb.append(product).append(System.lineSeparator());
//        }

        return sb.toString();
    }
}
