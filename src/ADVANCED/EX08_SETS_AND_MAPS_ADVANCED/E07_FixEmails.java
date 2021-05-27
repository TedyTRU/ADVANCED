package ADVANCED.EX08_SETS_AND_MAPS_ADVANCED;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E07_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        Map<String, String> emails = new LinkedHashMap<>();

        while (!"stop".equals(name)) {
            emails.putIfAbsent(name, "");
            String email = scanner.nextLine();

            //String check = email.substring(email.lastIndexOf('.') + 1).toLowerCase();
            if (email.endsWith("us") || email.endsWith("uk") || email.endsWith("com")) {
                emails.remove(name);
            } else {
                emails.put(name, email);
            }

            name = scanner.nextLine();
        }

        for (Map.Entry<String, String> entry : emails.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }

    }
}
