package ADVANCED.LAB07_SETS_AND_MAPS_ADVANCED;

import java.util.*;
import java.util.stream.Collectors;

public class L03_Voina_Number_game1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer> secondPlayer = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 50;

        while (rounds-- > 0 && !firstPlayer.isEmpty() && !secondPlayer.isEmpty()) {

            int first = 0;
            for (Integer integer : firstPlayer) {
                first = integer;
                break;
            }

            int second = secondPlayer.iterator().next();

            firstPlayer.remove(first);
            secondPlayer.remove(second);

            if (first > second) {
                firstPlayer.add(first);
                firstPlayer.add(second);

            } else if (second > first) {
                secondPlayer.add(first);
                secondPlayer.add(second);
            }

        }

        if (firstPlayer.size() == secondPlayer.size()) {
            System.out.println("Draw!");

        } else if (secondPlayer.size() < firstPlayer.size()) {
            System.out.println("First player win!");

        } else {
            System.out.println("Second player win!");
        }

    }
}
