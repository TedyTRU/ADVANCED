package ADVANCED.EX14_DEFINING_CLASSES.E06_PokemonTrainer;

public class Pokemon {

    private String name;
    private String element;
    private int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public String getElement() {
        return element;
    }

    public int getHealth() {
        return health;
    }

//    public void reduceHealth() {
//        this.health -= 10;
//    }

}
