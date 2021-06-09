package ADVANCED.EX14_DEFINING_CLASSES.E06_PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String lines = scanner.nextLine();
        Map<String, Trainer> trainers = new LinkedHashMap<>();

        while (!lines.equals("Tournament")) {

            lines = filTrainers(scanner, lines, trainers);
        }

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            for (Map.Entry<String, Trainer> entry : trainers.entrySet()) {
                if (entry.getValue().size() > 0) {
                    boolean hasPokemon = false;

                    for (Pokemon pokemon : entry.getValue().getPokemons()) {
                        if (pokemon.getElement().equals(command)) {
                            hasPokemon = true;
                            entry.getValue().increaseNumOfBadges();
                            break;
                        }
                    }
                    if (!hasPokemon) {
                        entry.getValue().reduceHealth();
                    }
                }
            }

            command = scanner.nextLine();
        }

        trainers.entrySet().stream()
                .sorted((b1, b2) -> Integer.compare(b2.getValue().getNumOfBadges(), b1.getValue().getNumOfBadges()))
                .forEach(trainer ->
                        System.out.printf("%s %d %d%n", trainer.getKey(), trainer.getValue().getNumOfBadges(),
                                trainer.getValue().size()));


    }

    private static String filTrainers(Scanner scanner, String lines, Map<String, Trainer> trainers) {
        String[] tokens = lines.split("\\s+");
        String nameOfTrainer = tokens[0];
        String nameOfPokemon = tokens[1];
        String element = tokens[2];
        int health = Integer.parseInt(tokens[3]);

        Pokemon pokemon = new Pokemon(nameOfPokemon, element, health);
        trainers.putIfAbsent(nameOfTrainer, new Trainer());
        trainers.get(nameOfTrainer).addPokemon(pokemon);

        lines = scanner.nextLine();
        return lines;
    }
}
