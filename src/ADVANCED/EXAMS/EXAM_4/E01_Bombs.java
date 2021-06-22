package ADVANCED.EXAMS.EXAM_4;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E01_Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> bombEffects = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> bombCasing = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).forEach(bombCasing::push);

        int cherryBombs = 0;
        int daturaBombs = 0;
        int smokeDecoyBombs = 0;
        boolean fulfillBombPouch = false;

        while (!bombEffects.isEmpty() && !bombCasing.isEmpty()) {

            int effects = bombEffects.poll();
            int casing = bombCasing.pop();

            if (effects + casing == 40) {
                daturaBombs++;
                //bombCasing.pop();
                //bombEffects.poll();

            } else if (effects + casing == 60) {
                cherryBombs++;
                //bombCasing.pop();
                //bombEffects.poll();


            } else if (effects + casing == 120) {
                smokeDecoyBombs++;
                //bombCasing.pop();
                //bombEffects.poll();

            } else {

                bombCasing.push(casing - 5);
                bombEffects.offerFirst(effects);

            }

            if (cherryBombs >= 3 && daturaBombs >= 3 && smokeDecoyBombs >= 3) {
                fulfillBombPouch = true;
                break;
            }
        }


        if (fulfillBombPouch) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");

        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (bombEffects.isEmpty()) {
            System.out.println("Bomb Effects: empty");

        } else {
            System.out.printf("Bomb Effects: %s%n",
                    String.join(", ", bombEffects.toString().replaceAll("[\\[\\]]", "")));

        }

        if (bombCasing.isEmpty()) {
            System.out.println("Bomb Casings: empty");

        } else {
            System.out.printf("Bomb Casings: %s%n"
                    , String.join(", ", bombCasing.toString().replaceAll("[\\[\\]]", "")));

        }

        System.out.printf("Cherry Bombs: %d%nDatura Bombs: %d%nSmoke Decoy Bombs: %d%n", cherryBombs, daturaBombs, smokeDecoyBombs);

    }
}
