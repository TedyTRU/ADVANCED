package ADVANCED.EX14_DEFINING_CLASSES.E09_CatLady;

import java.util.ArrayList;
import java.util.List;

public class Cat {

    private String name;
    private String breed;

    public Cat(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public String getName() {
        return this.name;
    }

    public String getBreed() {
        return this.breed;
    }

}
