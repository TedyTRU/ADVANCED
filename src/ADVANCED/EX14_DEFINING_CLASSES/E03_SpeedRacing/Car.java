package ADVANCED.EX14_DEFINING_CLASSES.E03_SpeedRacing;

public class Car {

    private String model;
    private double fuelAmount;
    private double fuelCost;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.distanceTraveled = 0;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelCost() {
        return fuelCost;
    }

    public boolean canMove(int amountOfKm) {
        if (this.fuelAmount / this.fuelCost >= amountOfKm) {
            return true;
        }
        return false;
    }

    public void moveCar(int amountOfKm) {
        this.distanceTraveled += amountOfKm;
        this.fuelAmount -= this.fuelCost * amountOfKm;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTraveled);
    }
}
