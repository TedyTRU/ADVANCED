package ADVANCED.LAB13_DEFINING_CLASSES.L02_Constructors;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    private static String defaultModel = "unknown";

    public Car(String brand) {
        this(brand, defaultModel, -1);
    }

    public Car(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }
}
