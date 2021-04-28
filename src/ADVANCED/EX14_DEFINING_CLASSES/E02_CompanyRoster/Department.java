package ADVANCED.EX14_DEFINING_CLASSES.E02_CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private List<Employee> employeeList;
    private String name;

    public Department() {
        this.employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        this.employeeList.add(employee);
    }

    public double getAverageSalary() {
        double averageSalary = 0.0;
        for (Employee employee : this.employeeList) {
            averageSalary += employee.getSalary();
        }
        return averageSalary / this.employeeList.size();
    }

}
