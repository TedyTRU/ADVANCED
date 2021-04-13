package ADVANCED.EX04_STACKS_AND_QUEUES;

import java.util.*;
import java.util.stream.Collectors;

public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        //ArrayDeque<Integer> plants = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        List<Integer> initialPlants = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        ArrayDeque<Integer> indexes = new ArrayDeque<>();
        int days = 0;

        while (true) {
            days++;

            int lastDeadDay = 0;

            for (int i = 0; i < n - 1; i++) {

                if (initialPlants.get(i + 1) > initialPlants.get(i)) {
                    indexes.push(i + 1);
                    lastDeadDay = 1;
                }
            }
            int deadPlantsCount = indexes.size();
            for (int i = 0; i < deadPlantsCount; i++) {
                int index = indexes.pop();
                initialPlants.remove(index);

            }
            n = initialPlants.size();

            if (lastDeadDay == 0) {
                System.out.println(days - 1);
                return;
            }

        }


    }
}
