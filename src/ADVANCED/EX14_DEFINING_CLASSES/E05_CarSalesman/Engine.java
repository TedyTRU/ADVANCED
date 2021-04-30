package ADVANCED.EX14_DEFINING_CLASSES.E05_CarSalesman;

public class Engine {

    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    private static int defaultDisplacement = 0;
    private static String defaultEfficiency = "n/a";

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power) {
        this(model, power, defaultDisplacement, defaultEfficiency);
    }

    public Engine(String model, int power, int displacement) {
        this(model, power, displacement, defaultEfficiency);
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power, defaultDisplacement, efficiency);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.model);
        sb.append(":")
                .append(System.lineSeparator());
        sb.append("Power: ")
                .append(this.power)
                .append(System.lineSeparator());
        sb.append("Displacement: ")
                .append(this.displacement == 0 ? "n/a" : this.displacement)
                .append(System.lineSeparator());
        sb.append("Efficiency: ")
                .append(this.efficiency)
                .append(System.lineSeparator());

        return sb.toString().trim();
    }
}
