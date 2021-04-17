package ADVANCED.EX08_SETS_AND_MAPS_ADVANCED;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E07_FixEmails_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String regex = ".[com|uk|us]+$";
        Pattern pattern = Pattern.compile(regex);

        Map<String, String> emails = new LinkedHashMap<>();

        while (!"stop".equals(name)) {
            String email = scanner.nextLine();
            Matcher matcher = pattern.matcher(email);

            if (!matcher.find()) {
                emails.put(name, email);
            }

            name = scanner.nextLine();
        }

        for (Map.Entry<String, String> entry : emails.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }

    }
}
