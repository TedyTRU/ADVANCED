package ADVANCED.EXAMS.EXAM_5.E03_vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {

    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public List<Pet> data() {
        return data;
    }

    public void add(Pet pet) {
        if (capacity > this.data.size()) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(d -> d.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        return this.data.stream()
                .filter(p -> p.getName().equals(name) && p.getOwner().equals(owner))
                .findFirst().orElse(null);
    }

    public Pet getOldestPet() {
        return this.data.stream()
                .min((p1, p2) -> Integer.compare(p2.getAge(), p1.getAge()))
                .orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder("The clinic has the following patients:")
                .append(System.lineSeparator());
        this.data.forEach(p -> sb.append(String.format("%s %s%n", p.getName(), p.getOwner())));
        return sb.toString();
    }
}
