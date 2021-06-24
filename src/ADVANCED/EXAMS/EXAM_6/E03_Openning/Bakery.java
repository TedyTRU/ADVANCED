package ADVANCED.EXAMS.EXAM_6.E03_Openning;

import java.util.ArrayList;
import java.util.List;

public class Bakery {

    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (this.capacity > this.employees.size()) {
            this.employees.add(employee);
        }
    }

    public boolean remove(String name) {
        return this.employees.removeIf(e -> e.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        return this.employees.stream().min((e1, e2) -> Integer.compare(e2.getAge(), e1.getAge()))
                .orElse(null);
    }

    public Employee getEmployee(String name) {
        return this.employees.stream().filter(e -> e.getName().equals(name))
                .findFirst().orElse(null);
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Bakery %s:%n", this.name));
        this.employees.forEach(e -> sb.append(e).append(System.lineSeparator()));

        return sb.toString();
    }
}
