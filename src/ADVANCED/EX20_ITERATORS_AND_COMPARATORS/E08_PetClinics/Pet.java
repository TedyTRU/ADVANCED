package ADVANCED.EX20_ITERATORS_AND_COMPARATORS.E08_PetClinics;

import ADVANCED.EX20_ITERATORS_AND_COMPARATORS.E06_StrategyPattern.Person;

public class Pet {
    private String name;
    private int age;
    private String kind;

    public Pet(String name, int age, String kind) {
        this.name = name;
        this.age = age;
        this.kind = kind;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s", name, age, kind);
    }
}
