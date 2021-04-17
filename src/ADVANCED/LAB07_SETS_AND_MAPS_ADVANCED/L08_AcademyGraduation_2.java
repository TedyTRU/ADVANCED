package ADVANCED.LAB07_SETS_AND_MAPS_ADVANCED;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class L08_AcademyGraduation_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(Double::parseDouble).collect(Collectors.toList());

            students.putIfAbsent(name, new ArrayList<>());
            students.put(name, grades);
        }

        DecimalFormat df = new DecimalFormat("##.############################");

        students.forEach((key, value) -> {
            double sum = 0;
            for (Double grade : value) {
                sum += grade;
            }
            double average = sum / value.size();
            System.out.printf("%s is graduated with %s%n", key, df.format(average));
        });

    }
}
