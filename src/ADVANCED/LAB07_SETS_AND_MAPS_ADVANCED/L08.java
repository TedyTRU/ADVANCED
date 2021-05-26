package ADVANCED.LAB07_SETS_AND_MAPS_ADVANCED;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class L08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> students = new TreeMap<>();

        IntStream.range(0, n).mapToObj(i -> scanner.nextLine())
                .forEach(name -> students.put(name, Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble).collect(Collectors.toList())));

        students.forEach((key, value) ->
                System.out.printf("%s is graduated with %s%n", key, getAverage(value)));

    }

    private static Double getAverage(List<Double> scores) {
        double average = 0.0;
        for (Double score : scores) {
            average += score;
        }
        average /= scores.size();
        return average;
    }
}
