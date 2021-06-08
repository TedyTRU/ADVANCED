package ADVANCED.EX14_DEFINING_CLASSES.E04_RawData_2;

public class Car {

    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tires tires;

    public Car (String model, Engine engine, Cargo cargo, Tires tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tires getTires() {
        return tires;
    }
}
