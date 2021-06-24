package ADVANCED.EXAMS.EXAM_6;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E01_Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquids = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(ingredients::push);

        int bread = 0;
        int cake = 0;
        int pastry = 0;
        int fruitPie = 0;

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int liquid = liquids.poll();
            int ingredient = ingredients.pop();
            int sum = liquid + ingredient;

            if (sum == 25) {
                bread++;

            } else if (sum == 50) {
                cake++;

            } else if (sum == 75) {
                pastry++;

            } else if (sum == 100) {
                fruitPie++;

            } else {
                ingredients.push(ingredient + 3);

            }

        }
        if (bread > 0 && cake > 0 && pastry > 0 && fruitPie > 0) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
//            System.out.println(String.format("Liquids left: %s"
//                    , liquids.toString().replaceAll("[\\[\\]]", "")));

            System.out.printf("Liquids left: %s%n", liquids.stream().map(String::valueOf)
            .collect(Collectors.joining(", ")));

        }

        if (ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
//            System.out.println(String.format("Ingredients left: %s"
//                    , ingredients.toString().replaceAll("[\\[\\]]", "")));

            System.out.printf("Ingredients left: %s%n", ingredients.stream().map(String::valueOf)
            .collect(Collectors.joining(", ")));
        }

        System.out.printf("Bread: %d%nCake: %d%nFruit Pie: %d%nPastry: %d%n", bread, cake, fruitPie, pastry);

//        System.out.printf("Bread: %d%n", bread);
//        System.out.printf("Cake: %d%n", cake);
//        System.out.printf("Fruit Pie: %d%n", fruitPie);
//        System.out.printf("Pastry: %d%n", pastry);

    }
}
