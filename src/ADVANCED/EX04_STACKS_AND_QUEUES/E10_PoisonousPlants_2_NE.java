package ADVANCED.EX04_STACKS_AND_QUEUES;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E10_PoisonousPlants_2_NE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> plants = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        ArrayDeque<Integer> indexes = new ArrayDeque<>();

        int days = 0;
        while (true) {

            boolean areDeadPlants = false;

            for (int i = 1; i < plants.size(); i++) {

                if (plants.get(i) > plants.get(i - 1)) {
                    indexes.push(i);
                    areDeadPlants = true;
                }
            }

            while (!indexes.isEmpty()) {
                int index = indexes.pop();
                plants.remove(index);
            }

            if (!areDeadPlants) {
                System.out.println(days);
                break;
            }

            days++;
        }

    }
}
