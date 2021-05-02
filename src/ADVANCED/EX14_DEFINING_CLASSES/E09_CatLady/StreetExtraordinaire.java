package ADVANCED.EX14_DEFINING_CLASSES.E09_CatLady;

public class StreetExtraordinaire extends Cat{

    private double decibelsOfMeows;

    public StreetExtraordinaire(String name, String breed, double decibelsOfMeows) {
        super(name, breed);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", getBreed(), getName(), this.decibelsOfMeows);
    }
}
