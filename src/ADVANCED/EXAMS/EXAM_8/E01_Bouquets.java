package ADVANCED.EXAMS.EXAM_8;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E01_Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tulips = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).forEach(tulips::push);

        ArrayDeque<Integer> daffodils = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        int storedFlowers = 0;
        int bouquet = 0;

        while (!tulips.isEmpty() && !daffodils.isEmpty()) {
            int tulip = tulips.poll();
            int daffodil = daffodils.pop();
            int sum = daffodil + tulip;

            if (sum > 15) {
                while (sum > 15) {
                    sum -= 2;
                }
            }
            if (sum == 15) {
                bouquet++;
            } else if (sum < 15) {
                storedFlowers += sum;
            }
        }

        bouquet += storedFlowers / 15;

        if (bouquet >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquet);

        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquet);
        }

    }

}
