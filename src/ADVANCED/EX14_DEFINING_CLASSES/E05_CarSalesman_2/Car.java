package ADVANCED.EX14_DEFINING_CLASSES.E05_CarSalesman_2;

public class Car {

    private String model;
    private Engine engine;
    private int weight = 0;
    private String color = "n/a";

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine);
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.model).append(":");
        sb.append(System.lineSeparator());
        sb.append(this.engine);
        sb.append("Weight: ").append(this.weight == 0 ? "n/a" : this.weight);
        sb.append(System.lineSeparator());
        sb.append("Color: ").append(this.color);

        return sb.toString();
    }
}
