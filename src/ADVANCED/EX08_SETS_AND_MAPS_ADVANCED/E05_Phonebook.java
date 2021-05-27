package ADVANCED.EX08_SETS_AND_MAPS_ADVANCED;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E05_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String names = scanner.nextLine();
        Map<String, String> phoneBook = new HashMap<>();

        while (!"search".equals(names)) {
            String[] token = names.split("-");
            String name = token[0];
            String phoneNumber = token[1];
            phoneBook.put(name, phoneNumber);

            names = scanner.nextLine();
        }

        names = scanner.nextLine();
        while (!"stop".equals(names)) {
            if (phoneBook.containsKey(names)) {
                String phone = phoneBook.get(names);
                System.out.printf("%s -> %s%n", names, phone);
            } else {
                System.out.printf("Contact %s does not exist.%n", names);
            }

            names = scanner.nextLine();
        }

    }
}
