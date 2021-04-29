package ADVANCED.EX14_DEFINING_CLASSES.E05_CarSalesman;

public class Car {

    private String model;
    private String engineModel;
    private int weight;
    private String colour;

    //private static String defaultWeight = "n/a";
    //private static String defaultColour = "n/a";

    public Car(String model, String engineModel, int weight, String colour) {
        this(model, engineModel);
        this.weight = weight;
        this.colour = colour;
    }

    public Car(String model, String engineModel) {
        this.model = model;
        this.engineModel = engineModel;
    }

    public Car(String model, String engineModel, int weight) {
        this(model, engineModel);
        this.weight = weight;
    }

    public Car(String model, String engineModel, String colour) {
        this(model, engineModel);
        this.colour = colour;
    }
}
