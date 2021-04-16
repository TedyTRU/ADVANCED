package ADVANCED.LAB07_SETS_AND_MAPS_ADVANCED;

import java.util.*;
import java.util.stream.Collectors;

public class L02_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> regular = new TreeSet<>();
        Set<String> VIP = new TreeSet<>();

        String guest = scanner.nextLine();
        while (!"PARTY".equalsIgnoreCase(guest)) {

            if (Character.isDigit(guest.charAt(0))) {
                VIP.add(guest);
            } else {
                regular.add(guest);
            }

            guest = scanner.nextLine();
        }

        guest = scanner.nextLine();
        while (!guest.equalsIgnoreCase("END")) {

            if (Character.isDigit(guest.charAt(0))) {
                VIP.remove(guest);
            } else {
                regular.remove(guest);
            }

            guest = scanner.nextLine();
        }

        System.out.println(VIP.size() + regular.size());
        if (!VIP.isEmpty()) {
            System.out.println(getSetElementsOnNewLines(VIP));
        }
        if (!regular.isEmpty()) {
            System.out.println(getSetElementsOnNewLines(regular));
        }
    }

    public static String getSetElementsOnNewLines(Set<String> set) {
        return set.stream().collect(Collectors.joining(System.lineSeparator()));
    }

}
