package ADVANCED.EX10_STREAMS_FILES_AND_DIRECTORIES;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class E10_SerializeArrayList {

    private static final String PATH = "src/ADVANCED/EX10_STREAMS_FILES_AND_DIRECTORIES/Resources/list.ser";

    public static void main(String[] args) throws IOException {

        List<Double> list = List.of(4.5, 3.3, 3.7, 1.0, 8.8);

        try (FileOutputStream fos = new FileOutputStream(PATH);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(list);
        }

        try (FileInputStream fis = new FileInputStream(PATH);
             ObjectInputStream oos = new ObjectInputStream(fis)) {

            List<Double> deserializedList = (List<Double>) oos.readObject();

            deserializedList.forEach(e -> System.out.println(e));

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }
}
