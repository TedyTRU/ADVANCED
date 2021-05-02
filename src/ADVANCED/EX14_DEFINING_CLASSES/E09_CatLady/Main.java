package ADVANCED.EX14_DEFINING_CLASSES.E09_CatLady;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, Cat> cats = new HashMap<>();

        while (!line.equals("End")) {
            String[] catsInfo = line.split("\\s+");
            String breed = catsInfo[0];
            String name = catsInfo[1];
            double characteristic = Double.parseDouble(catsInfo[2]);

            switch (breed) {
                case "Siamese":
                    cats.put(name, new Siamese(name, breed, characteristic));
                    break;

                case "Cymric":
                    cats.put(name, new Cymric(name, breed, characteristic));

                    break;

                case "StreetExtraordinaire":
                    cats.put(name, new StreetExtraordinaire(name, breed, characteristic));

                    break;
            }

            line = scanner.nextLine();
        }

        String cat = scanner.nextLine();
        System.out.println(cats.get(cat));

    }
}
