package ADVANCED.EX14_DEFINING_CLASSES.E04_RawData;

import java.sql.Struct;

public class Tire {

    private double tire1Pressure;
    private int tire1Age;
    private double tire2Pressure;
    private int tire2Age;
    private double tire3Pressure;
    private int tire3Age;
    private double tire4Pressure;
    private int tire4Age;

    public Tire(double tire1Pressure, int tyre1Age, double tire2Pressure, int tyre2Age, double tire3Pressure, int tyre3Age, double tire4Pressure, int tyre4Age) {
        this.tire1Pressure = tire1Pressure;
        this.tire1Age = tyre1Age;
        this.tire2Pressure = tire2Pressure;
        this.tire2Age = tyre2Age;
        this.tire3Pressure = tire3Pressure;
        this.tire3Age = tyre3Age;
        this.tire4Pressure = tire4Pressure;
        this.tire4Age = tyre4Age;
    }

    public double getAveragePressure() {
        return (this.tire1Pressure + this.tire2Pressure +
                this.tire3Pressure + this.tire4Pressure) / 4;
    }

    public boolean hasLowPressure() {
        if (tire1Pressure < 1.0 || tire2Pressure < 1.0 ||
        tire3Pressure < 1.0 || tire4Pressure <1.0) {
            return true;
        }
        return false;
    }

}
