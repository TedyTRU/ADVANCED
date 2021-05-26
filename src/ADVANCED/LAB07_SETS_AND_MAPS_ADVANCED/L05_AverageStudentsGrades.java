package ADVANCED.LAB07_SETS_AND_MAPS_ADVANCED;

import java.util.*;

public class L05_AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> students = new TreeMap<>();

        while (n-- > 0) {
            String[] lines = scanner.nextLine().split("\\s+");
            String name = lines[0];
            double grade = Double.parseDouble(lines[1]);

            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);

        }

        students.entrySet()
                .stream()
                //.sorted((name1, name2) -> name2.getKey().compareTo(name1.getKey()))
                .forEach(entry -> {

                    double average = 0.0;
                    for (Double grade : entry.getValue()) {
                        average += grade;
                    }
                    average /= entry.getValue().size();

                    System.out.printf("%s -> ", entry.getKey());
                    entry.getValue().forEach(g -> System.out.printf("%.2f ", g));
                    System.out.printf("(avg: %.2f)%n", average);
                    //System.out.printf("(avg: %.2f)%n", entry.getValue().stream().mapToDouble(d -> d).average().orElse(0.0));
                });

    }
}
