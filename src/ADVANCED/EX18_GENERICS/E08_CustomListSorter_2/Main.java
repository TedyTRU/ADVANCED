package ADVANCED.EX18_GENERICS.E08_CustomListSorter_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> elements = new CustomList<>();

        String command = scanner.nextLine();
        while (!"END".equals(command)) {
            String[] tokens = command.split("\\s+");

            switch (tokens[0]) {
                case "Add":
                    elements.add(tokens[1]);
                    break;

                case "Remove":
                    elements.remove(Integer.parseInt(tokens[1]));
                    break;

                case "Contains":
                    System.out.println(elements.contains(tokens[1]));
                    break;

                case "Swap":
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);
                    elements.swap(firstIndex, secondIndex);
                    break;

                case "Greater":
                    long count = elements.countGreaterThan(tokens[1]);
                    System.out.println(count);
                    break;

                case "Max":
                    System.out.println(elements.getMax());
                    break;

                case "Min":
                    System.out.println(elements.getMin());
                    break;

                case "Print":
                    elements.print();
                    break;

                case "Sort":
                    Sorter.sort(elements);

            }

            command = scanner.nextLine();
        }


    }

}
