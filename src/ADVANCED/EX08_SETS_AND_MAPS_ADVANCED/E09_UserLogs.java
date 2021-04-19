package ADVANCED.EX08_SETS_AND_MAPS_ADVANCED;

import java.util.*;

public class E09_UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, LinkedHashMap<String, Integer>> userLogs = new TreeMap<>();

        while (!"end".equals(line)) {
            String[] token = line.split("\\s+");
            String IP = token[0].split("=")[1];
            String message = token[1].split("=")[1];
            String user = token[2].split("=")[1];

            userLogs.putIfAbsent(user, new LinkedHashMap<>());
            userLogs.get(user).putIfAbsent(IP, 0);

            int count = userLogs.get(user).get(IP);
            userLogs.get(user).put(IP, count + 1);

            line = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> mapEntry : userLogs.entrySet()) {
            System.out.printf("%s:%n", mapEntry.getKey());

            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Integer> entry : mapEntry.getValue().entrySet()) {
                String output = String.format("%s => %d", entry.getKey(), entry.getValue());
                sb.append(output).append(", ");
            }
            String result = sb.substring(0, sb.length() - 2);
            System.out.println(result + ".");

        }

    }
}
