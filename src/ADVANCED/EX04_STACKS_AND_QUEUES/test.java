package ADVANCED.EX04_STACKS_AND_QUEUES;

import java.util.*;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> initialPlants = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int days = 0;

        while (true) {
            int currentPlant = initialPlants.get(0);
            for (int i = 1; i < initialPlants.size(); i++) {

                if (currentPlant < initialPlants.get(i)) {
                    currentPlant = initialPlants.get(i);
                    initialPlants.set(i, -1);

                } else {
                    currentPlant = initialPlants.get(i);
                }
            }

            if (initialPlants.contains(-1)) {
                initialPlants.removeIf(plant -> plant == -1);
                days++;

            } else {
                break;
            }
        }

        System.out.println(days);
    }
}
