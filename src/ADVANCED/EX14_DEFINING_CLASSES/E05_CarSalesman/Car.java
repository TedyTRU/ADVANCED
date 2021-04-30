package ADVANCED.EX14_DEFINING_CLASSES.E05_CarSalesman;

public class Car {

    private String model;
    private Engine engineModel;
    private int weight;
    private String colour;

    private static int defaultWeight = 0;
    private static String defaultColour = "n/a";

    public Car(String model, Engine engineModel, int weight, String colour) {
        this.model = model;
        this.engineModel = engineModel;
        this.weight = weight;
        this.colour = colour;
    }

    public Car(String model, Engine engineModel) {
        this(model, engineModel, defaultWeight, defaultColour);
    }

    public Car(String model, Engine engineModel, int weight) {
        this(model, engineModel, weight, defaultColour);
    }

    public Car(String model, Engine engineModel, String colour) {
        this(model, engineModel, 0, colour);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.model);
        sb.append(": ")
                .append(System.lineSeparator())
                .append(this.engineModel)
                .append(System.lineSeparator());
        sb.append("Weight: ")
                .append(this.weight == 0 ? "n/a" : this.weight)
                .append(System.lineSeparator());
        sb.append("Color: ")
                .append(this.colour);

        return sb.toString().trim();
    }
}
