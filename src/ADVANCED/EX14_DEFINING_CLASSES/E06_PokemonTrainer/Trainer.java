package ADVANCED.EX14_DEFINING_CLASSES.E06_PokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trainer {

    //private String name;
    private int numOfBadges;
    private List<Pokemon> pokemons;

    public Trainer() {
        this.numOfBadges = 0;
        this.pokemons = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

//    public List<Pokemon> getPokemons() {
//        return new ArrayList<>(this.pokemons);
//    }

//    public String getElement(Pokemon pokemon) {
//        return pokemon.getElement();
//    }

    public int size() {
        return this.pokemons.size();
    }

    public int getNumOfBadges() {
        return numOfBadges;
    }

    public void increaseNumOfBadges() {
        this.numOfBadges++;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void reduceHealth() {
        this.pokemons = this.pokemons.stream()
                .map(pokemon ->
                        new Pokemon(pokemon.getName(), pokemon.getElement(), pokemon.getHealth() - 10))
                .filter(pokemon -> pokemon.getHealth() > 0)
                .collect(Collectors.toList());
    }

}
