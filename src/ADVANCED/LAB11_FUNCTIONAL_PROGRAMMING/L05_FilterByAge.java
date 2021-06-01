package ADVANCED.LAB11_FUNCTIONAL_PROGRAMMING;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class L05_FilterByAge {

    public static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<String, Person> parsePerson = string ->
                new Person(string.split(", ")[0], Integer.parseInt(string.split(", ")[1]));

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> persons = new ArrayList<>();

        while (n-- > 0) {
            persons.add(parsePerson.apply(scanner.nextLine()));
        }

        String condition = scanner.nextLine();
        int ageCondition = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        persons = condition.equals("older")
                ? filterPeople(persons, p -> p.age >= ageCondition)
                : filterPeople(persons, p -> p.age <= ageCondition);

        System.out.println(formatPeople(persons, getFormatFunction(format), System.lineSeparator()));

    }

    private static String formatPeople(List<Person> people, Function<Person, String> formatter, String delimiter) {
        return people.stream().map(formatter).collect(Collectors.joining(delimiter));
    }

    private static Function<Person, String> getFormatFunction(String formatType) {
        switch (formatType) {
            case "name":
                return p -> p.name;
            case "age":
                return p -> String.valueOf(p.age);
            case "name age":
                return p -> p.name + " - " + p.age;
            default:
                throw new IllegalStateException("Unknown format type " + formatType);
        }
    }

    private static List<Person> filterPeople(List<Person> list, Predicate<Person> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

}
