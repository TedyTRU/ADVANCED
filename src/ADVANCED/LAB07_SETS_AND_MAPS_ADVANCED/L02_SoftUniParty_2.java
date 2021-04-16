package ADVANCED.LAB07_SETS_AND_MAPS_ADVANCED;

import java.util.*;
import java.util.stream.Collectors;

public class L02_SoftUniParty_2 {

//    private static class GuestComparator implements Comparator<String> {
//        @Override
//        public int compare(String first, String second) {
//
//            if (first.equals(second)) {
//                return 0;
//            }
//
//            boolean firstIsVip = Character.isDigit(first.charAt(0));
//            boolean secondIsVip = Character.isDigit(first.charAt(0));
//
//            if (!firstIsVip && secondIsVip) {
//                return -1;
//                //return Boolean.compare(firstIsVip, secondIsVip);
//            }
//            return 1;
//        }
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> guests = new TreeSet<>();

        String guest = scanner.nextLine();
        while (!"PARTY".equalsIgnoreCase(guest)) {
            guests.add(guest);
            guest = scanner.nextLine();
        }

        guest = scanner.nextLine();
        while (!guest.equalsIgnoreCase("END")) {
            guests.remove(guest);
            guest = scanner.nextLine();
        }

        System.out.println(guests.size());
        System.out.println(getSetElementsOnNewLines(guests));
    }

    public static String getSetElementsOnNewLines(Set<String> set) {
        return set.stream().collect(Collectors.joining(System.lineSeparator()));
    }
}