package ADVANCED.EX14_DEFINING_CLASSES.E04_RawData_2;

public class Engine {

    private int speed;
    private int power;

    public Engine(int speed, int power) {
        this.speed = speed;
        this.power = power;
    }

    public int getPower() {
        return this.power;
    }

    public boolean hasHighPower() {
        return this.power > 250;
    }

}
