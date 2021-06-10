package ADVANCED.EXAMS.EXAM_1.E03_HealthyHeaven;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Restaurant {

    private String name;
    private List<Salad> data;

    public Restaurant(String name) {
        this.name = name;
        this.data = new ArrayList<>();
    }

    public void add(Salad salad) {
        this.data.add(salad);
    }

    public boolean buy(String name) {
//        for (Salad salad : this.salads) {
//            if (salad.getName().equals(name)) {
//                salads.remove(name);
//                return true;
//            }
//        }
//        return false;

        return this.data.removeIf(e -> e.getName().equals(name));
    }

    public Salad getHealthiestSalad() {
       return this.data.stream()
               .min(Comparator.comparing(Salad::getTotalCalories))
               .orElseThrow();
    }

    public String generateMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s have %d salads:"
                , this.name, this.data.size())).append(System.lineSeparator());

        this.data.forEach(sb::append);

        return sb.toString();
    }

}
