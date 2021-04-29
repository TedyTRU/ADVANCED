package ADVANCED.EX14_DEFINING_CLASSES.E04_RawData;

public class Car {

    private String carModel;
    private Engine engine;
    private Cargo cargo;
    private Tire tire;

    public Car(String carModel, Engine engine, Cargo cargo, Tire tire) {
        this.carModel = carModel;
        this.engine = engine;
        this.cargo = cargo;
        this.tire = tire;
    }

    public String getCarModel() {
        return carModel;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tire getTire() {
        return tire;
    }
}
