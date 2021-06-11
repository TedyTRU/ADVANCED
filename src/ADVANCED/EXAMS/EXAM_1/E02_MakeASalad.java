package ADVANCED.EXAMS.EXAM_1;

import java.util.*;
import java.util.stream.Collectors;

public class E02_MakeASalad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        Map<String, Integer> tableOfCalories = new HashMap<>();
//        tableOfCalories.put("tomato", 80);
//        tableOfCalories.put("carrot", 136);
//        tableOfCalories.put("lettuce", 109);
//        tableOfCalories.put("potato", 215);

        ArrayDeque<String> vegetables = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> calories = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(calories::push);

        List<Integer> salads = new ArrayList<>();

        while (!vegetables.isEmpty() && !calories.isEmpty()) {

            int salad = calories.pop();
            salads.add(salad);

            while (salad > 0 && !vegetables.isEmpty()) {

                switch (vegetables.poll()) {
                    case "tomato": salad -= 80; break;
                    case "carrot": salad -= 136; break;
                    case "lettuce": salad -= 109; break;
                    case "potato": salad -= 215; break;
                }

                //int vegetableCalorie = tableOfCalories.get(vegetables.poll());
                //salad -= vegetableCalorie;
                //salad -= tableOfCalories.get(vegetables.poll());

            }

        }

        salads.forEach(salad -> System.out.print(salad + " "));
        System.out.println();

        if (!vegetables.isEmpty()) {
            vegetables.forEach(vegetable -> System.out.print(vegetable + " "));

        }
        if (!calories.isEmpty()) {
            calories.forEach(calorie -> System.out.print(calorie + " "));

        }

    }
}
