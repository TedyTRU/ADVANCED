package ADVANCED.EX14_DEFINING_CLASSES.E07_Google;

public class Company {

    private String name;
    private String department;
    private double salary;

    public Company() {
    }

    public Company(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String format() {
        return String.format("%s %s %.2f", this.name, this.department, this.salary);
    }

}
