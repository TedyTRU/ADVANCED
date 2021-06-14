package ADVANCED.EXAMS.EXAM_2.Е03_Rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {

    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void add(Rabbit rabbit) {
        if (this.data.size() < this.capacity) {
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
        return this.data.removeIf(e -> e.getName().equals(name));
    }

    public void removeSpecies(String species) {
        this.data = this.data.stream()
                .filter(e -> !e.getSpecies().equals(species))
                .collect(Collectors.toList());
    }

    public Rabbit sellRabbit(String name) {
        this.data.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst().ifPresent(e -> e.setAvailable(false));
        return this.data.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst().orElse(null);
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        this.data.stream()
                .filter(e -> e.getSpecies().equals(species))
                .forEach(e -> e.setAvailable(false));
        return this.data.stream()
                .filter(e -> e.getSpecies().equals(species))
                .collect(Collectors.toList());
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Rabbits available at %s:", this.name));
        sb.append(System.lineSeparator());

        this.data.stream()
                .filter(e -> e.isAvailable())
                .forEach(v -> sb.append(v).append(System.lineSeparator()));

        return sb.toString();
    }


}
