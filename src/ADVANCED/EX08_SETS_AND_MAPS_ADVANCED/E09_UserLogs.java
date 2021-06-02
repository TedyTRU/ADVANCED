package ADVANCED.EX08_SETS_AND_MAPS_ADVANCED;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class E09_UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, LinkedHashMap<String, Integer>> info = new TreeMap<>();

        while (!line.equals("end")) {
            int startIndexIP = line.indexOf("=") + 1;
            int endIndexIP = line.indexOf(" ");
            int startIndexUser = line.lastIndexOf("=") + 1;

            String IP = line.substring(startIndexIP, endIndexIP);
            String user = line.substring(startIndexUser);

            if (info.containsKey(user)) {

                if (info.get(user).containsKey(IP)) {
                    int count = info.get(user).get(IP) + 1;
                    info.get(user).put(IP, count);
                } else {
                    info.get(user).put(IP, 1);
                }

            } else {
                info.put(user, new LinkedHashMap<>());
                info.get(user).put(IP, 1);
            }

            line = scanner.nextLine();
        }

        info.forEach((key, value) -> {
            System.out.println(key + ": ");
            int count = value.size();
            for (var address : value.entrySet()) {

                if (count-- > 1) {
                    System.out.print(address.getKey() + " => " + address.getValue() + ", ");
                } else {
                    System.out.print(address.getKey() + " => " + address.getValue() + ".");
                }
            }
            System.out.println();
        });

    }
}
