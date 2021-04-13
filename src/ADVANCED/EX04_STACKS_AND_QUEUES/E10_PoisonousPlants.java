package ADVANCED.EX04_STACKS_AND_QUEUES;

import java.util.*;
import java.util.stream.Collectors;

public class E10_PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        //ArrayDeque<Integer> plants = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        List<Integer> initialPlants = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        ArrayDeque<Integer> StackOfIndexes = new ArrayDeque<>();
        int days = 0;

        while (true) {
            days++;
            boolean deadPlants = false;

            for (int i = 0; i < n - 1; i++) {
                if (initialPlants.get(i + 1) > initialPlants.get(i)) {
                    StackOfIndexes.push(i + 1);
                    deadPlants = true;
                }
            }

            int deadPlantsCount = StackOfIndexes.size();
            for (int i = 0; i < deadPlantsCount; i++) {
                int index = StackOfIndexes.pop();
                initialPlants.remove(index);

            }

            n = initialPlants.size();

            if (!deadPlants) {
                System.out.println(days - 1);
                return;
            }
        }

    }
}
