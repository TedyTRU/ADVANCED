package ADVANCED.EX14_DEFINING_CLASSES.E02_CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Employee> employees = new ArrayList<>();
        Map<String, Department> departments = new HashMap<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            Employee employee = null;
            departments.putIfAbsent(department, new Department());

            if (tokens.length == 6) {
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);

                employee = new Employee(name, salary, position, department,
                        email, age);

            } else if (tokens.length == 4) {
                employee = new Employee(name, salary, position, department);

            } else if (tokens.length == 5) {
                if (tokens[4].matches("^\\d+$")) {
                    int age = Integer.parseInt(tokens[4]);
                    employee = new Employee(name, salary, position, department, age);
                } else {
                    String emial = tokens[4];
                    employee = new Employee(name, salary, position, department, emial);
                }


            }
            employees.add(employee);
            departments.get(department).addEmployee(employee);

        }



    }
}
