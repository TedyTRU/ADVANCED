package ADVANCED.EX20_ITERATORS_AND_COMPARATORS.E05_ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = "";
        List<Person> people = new ArrayList<>();

        while (!"END".equals(line = sc.nextLine())) {
            String[] personInfo = line.split("\\s+");
            String name= personInfo[0];
            int age = Integer.parseInt(personInfo[1]);
            String town = personInfo[2];
            Person person = new Person(name, age, town);

            people.add(person);
        }

        int index = Integer.parseInt(sc.nextLine());
        Person person = people.get(index - 1);

        int equalPeople = 0;
        for (Person person1 : people) {
            if (person.compareTo(person1) == 0) {
                equalPeople++;
            }
        }

        if (equalPeople == 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d%n", equalPeople, (people.size() - equalPeople), people.size());
        }

    }
}
