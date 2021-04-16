package ADVANCED.LAB07_SETS_AND_MAPS_ADVANCED;

import java.text.DecimalFormat;
import java.util.*;

public class L08_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, double[]> students = new TreeMap<>();

        while (n-- > 0) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

            students.put(name, grades);

        }

//        DecimalFormat df = new DecimalFormat("0.#################");
//        students.forEach((k, v) -> {
//            System.out.printf("%s is graduated with ", k);
//            System.out.print(df.format(Arrays.stream(v).average().orElse(0)));
//            System.out.println();
//
//        });

        students.forEach((k, v) -> {
            System.out.printf("%s is graduated with %f%n", k,
                    Arrays.stream(v).average().orElse(0));

        });

    }
}
