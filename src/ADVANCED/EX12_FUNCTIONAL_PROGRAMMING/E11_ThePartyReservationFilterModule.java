package ADVANCED.EX12_FUNCTIONAL_PROGRAMMING;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class E11_ThePartyReservationFilterModule {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> invitedNames = Arrays.stream(scanner.nextLine()
                .split("\\s+")).collect(Collectors.toList());

        Set<String> filterSet = new HashSet<>();

        String line = scanner.nextLine();
        while (!"Print".equals(line)) {
        String[] tokens = line.split(";");

        if (tokens[0].equals("Add filter")) {
            filterSet.add(tokens[1] + ";" + tokens[2]);

        } else if (tokens[0].equals("Remove filter")) {
            filterSet.remove(tokens[1] + ";" + tokens[2]);

        }
            line = scanner.nextLine();
        }

        filterSet.forEach(filter -> invitedNames.removeIf(getPredicate(filter)));
        printList(invitedNames);

    }

    private static void printList(List<String> list) {
        for (String name : list) {
            System.out.print(name + " ");
        }
    }

    private static Predicate<String> getPredicate(String filter) {
        Predicate<String> predicate = null;
        String[] tokens = filter.split(";");

        if (tokens[0].equals("Starts with")) {
            predicate = name -> name.startsWith(tokens[1]);

        } else if (tokens[0].equals("Ends with")) {
            predicate = name -> name.endsWith(tokens[1]);

        } else if (tokens[0].equals("Length")) {
            predicate = name -> name.length() == Integer.parseInt(tokens[1]);

        } else if (tokens[0].equals("Contains")) {
            predicate = name -> name.contains(tokens[1]);

        }
        return predicate;
    }

}
