package ADVANCED.EX14_DEFINING_CLASSES.E04_RawData;

public class Cargo {

    private int weight;
    private String type;

    public Cargo(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
