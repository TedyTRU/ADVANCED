package ADVANCED.EX12_FUNCTIONAL_PROGRAMMING;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class E10_PredicateParty_2 {

    static List<String> invitedGuests = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        invitedGuests = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String commands = scanner.nextLine();

        while (!"Party!".equals(commands)) {
            String[] tokens = commands.split("\\s+");

            switch (tokens[0]) {
                case "Double":
                    addMoreNames(getPredicate(tokens));
                    break;
                case "Remove":
                    removeNames(getPredicate(tokens));
                    break;

            }

            commands = scanner.nextLine();
        }

        Collections.sort(invitedGuests);
        Consumer<List<String>> printNames = list -> {
            if (invitedGuests.isEmpty()) {
                System.out.println("Nobody is going to the party!");
            } else {
                Collections.sort(invitedGuests);
                System.out.println(invitedGuests.toString().replaceAll("([\\]\\[])", "") + " are going to the party!");
            }
        };

        // To Do
        //Function<Predicate<String>, List<String>>

    }

    public static void removeNames(Predicate<String> predicate) {
        invitedGuests.removeIf(predicate);
    }

    public static void addMoreNames(Predicate<String> predicate) {
        List<String> namesToAdd = new ArrayList<>();
        invitedGuests.stream().filter(predicate).forEach(namesToAdd::add);
        invitedGuests.addAll(namesToAdd);
    }

    private static Predicate<String> getPredicate(String[] tokens) {
        Predicate<String> predicate = null;

        if (tokens[1].equals("StartsWith")) {
            predicate = name -> name.startsWith(tokens[2]);

        } else if (tokens[1].equals("EndsWith")) {
            predicate = name -> name.endsWith(tokens[2]);

        } else {
            predicate = name -> name.length() == Integer.parseInt(tokens[2]);
        }

        return predicate;
    }
}
