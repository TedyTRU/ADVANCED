package ADVANCED.EX10_STREAMS_FILES_AND_DIRECTORIES;

import java.io.*;
import java.util.List;

public class E11_SerializeCustomObject {

    private static final String PATH = "src/ADVANCED/EX10_STREAMS_FILES_AND_DIRECTORIES/Resources/list.ser";

    public static void main(String[] args) throws IOException {

        Course course = new Course("Java Advanced", 200);

        try (FileOutputStream fos = new FileOutputStream(PATH);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(course);
        }

        try (FileInputStream fis = new FileInputStream(PATH);
             ObjectInputStream oos = new ObjectInputStream(fis)) {

            Course deserializedCourse = (Course) oos.readObject();

            System.out.println(deserializedCourse);

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    private static class Course implements Serializable {
        private String name;
        private int studentCount;

        public String getName() {
            return name;
        }

        public int getStudentCount() {
            return studentCount;
        }

        public Course(String name, int studentCount) {
            this.name = name;
            this.studentCount = studentCount;

        }

        @Override
        public String toString() {
            return String.format("%s -> %d", this.getName(), this.getStudentCount());
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setStudentCount(int studentCount) {
            this.studentCount = studentCount;
        }
    }

}