package ADVANCED.EX14_DEFINING_CLASSES.E07_Google;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private Company company;
    private List<Pokemon> pokemonList;
    private List<Parents> parents;
    private List<Children> children;
    private Car car;

    public Person(String name) {
        this.name = name;
        this.company = new Company();
        this.pokemonList = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.car = new Car();
    }

    public void addCompany(Company company) {
        this.company = company;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }

    public void addParents(Parents parents) {
        this.parents.add(parents);
    }

    public void addChildren(Children children) {
        this.children.add(children);
    }

    public void addCar(Car car) {
        this.car = car;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Pokemon> getPokemonList() {
        return this.pokemonList;
    }

    public void printFormat() {
        System.out.println(this.name);
        System.out.println("Company:");
        if (this.company != null) {
            System.out.println(this.company.format());
        }
        System.out.println("Car:");
        System.out.println(this.car == null ? "car is empty" : this.car.format());
        System.out.println("Pokemon:");
        if (!this.pokemonList.isEmpty()) {
            getPokemonList().forEach(pokemon ->
                    System.out.printf("%s%n", pokemon.toString()));
        }
        System.out.println("Parents:");
        if (!this.parents.isEmpty()) {
            parents.forEach(parents1 -> System.out.printf("%s%n", parents1));
        }
        System.out.println("Children:");
        if (!this.children.isEmpty()) {
            children.forEach(child -> System.out.printf("%s%n", child));
        }
    }
}
