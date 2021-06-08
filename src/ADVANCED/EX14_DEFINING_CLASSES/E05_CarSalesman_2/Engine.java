package ADVANCED.EX14_DEFINING_CLASSES.E05_CarSalesman_2;

public class Engine {

    private String model;
    private int power;
    private int displacement = 0;
    private String efficiency = "n/a";

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this(model, power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement) {
        this(model, power);
        this.displacement = displacement;
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.model).append(":");
        sb.append(System.lineSeparator());
        sb.append("Power: ").append(this.power);
        sb.append(System.lineSeparator());
        sb.append("Displacement: ").append(this.displacement == 0 ?
                "n/a" : this.displacement);
        sb.append(System.lineSeparator());
        sb.append("Efficiency: ").append(this.efficiency);
        sb.append(System.lineSeparator());

        return sb.toString();
    }
}
