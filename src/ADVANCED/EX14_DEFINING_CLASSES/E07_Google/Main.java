package ADVANCED.EX14_DEFINING_CLASSES.E07_Google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String information = scanner.nextLine();
        Map<String, Person> people = new HashMap<>();

        while (!information.equals("End")) {

            information = fillMapOfPeople(scanner, information, people);
        }

        String name = scanner.nextLine();
        people.get(name).printFormat();
    }

    private static String fillMapOfPeople(Scanner scanner, String information, Map<String, Person> people) {
        String[] tokens = information.split("\\s+");

        String name = tokens[0];
        people.putIfAbsent(name, new Person(name));

        String command = tokens[1];

        if (command.equals("company")) {
            String nameOfCompany = tokens[2];
            String department = tokens[3];
            double salary = Double.parseDouble(tokens[4]);

            Company company = new Company(nameOfCompany, department, salary);
            people.get(name).addCompany(company);

        } else if (command.equals("pokemon")) {
            String nameOfPokemon = tokens[2];
            String type = tokens[3];

            Pokemon pokemon = new Pokemon(nameOfPokemon, type);
            people.get(name).addPokemon(pokemon);

        } else if (command.equals("parents")) {
            String parentName = tokens[2];
            String parentBirthday = tokens[3];

            Parents parents = new Parents(parentName, parentBirthday);
            people.get(name).addParents(parents);

        } else if (command.equals("children")) {
            String childName = tokens[2];
            String childBirthday = tokens[3];

            Children children = new Children(childName, childBirthday);
            people.get(name).addChildren(children);

        } else if (command.equals("car")) {
            String model = tokens[2];
            int speed = Integer.parseInt(tokens[3]);

            Car car = new Car(model, speed);
            people.get(name).addCar(car);

        }

        information = scanner.nextLine();
        return information;
    }
}
