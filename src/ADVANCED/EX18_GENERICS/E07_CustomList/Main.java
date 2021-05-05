package ADVANCED.EX18_GENERICS.E07_CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> list = new CustomList<>();
        String line = scanner.nextLine();

        while (!line.equals("END")) {
            String[] command = line.split("\\s+");

            switch (command[0]) {
                case "Add":
                    String element = command[1];
                    list.add(element);
                    break;
                case "Remove":
                    int index = Integer.parseInt(command[1]);
                    list.remove(index);
                    break;
                case "Contains":
                    element = command[1];
                    System.out.println(list.contains(element));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(command[1]);
                    int secondIndex = Integer.parseInt(command[2]);
                    list.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    element = command[1];
                    System.out.println(list.countGreaterThan(element));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    list.print();
                    break;
            }
            line = scanner.nextLine();
        }

    }
}
