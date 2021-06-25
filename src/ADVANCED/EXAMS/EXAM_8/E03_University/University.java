package ADVANCED.EXAMS.EXAM_8.E03_University;

import java.util.ArrayList;
import java.util.List;

public class University {

    public List<Student> students;
    public int capacity;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {

        if (this.students.contains(student)) {
            return "Student is already in the university";

        } else if (this.capacity > this.students.size()) {
            this.students.add(student);
            return String.format("Added student %s %s", student.getFirstName(), student.getLastName());

        } else {
            return "No seats in the university";
        }
    }

    public String dismissStudent(Student student) {
        if (this.students.contains(student)) {
            this.students.remove(student);
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());

        } else {
            return "Student not found";
        }
    }

    public Student getStudent(String firstName, String lastName) {
        return this.students.stream().filter(s -> s.getFirstName().equals(firstName) &&
                s.getLastName().equals(lastName)).findAny().orElse(null);
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        this.students.forEach(s ->
                sb.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s%n"
                        , s.getFirstName(), s.getLastName(), s.getBestSubject())));

        return sb.toString();
    }

}
