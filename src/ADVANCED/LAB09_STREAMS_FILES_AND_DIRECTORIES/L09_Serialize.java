package ADVANCED.LAB09_STREAMS_FILES_AND_DIRECTORIES;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class L09_Serialize {
    public static void main(String[] args) throws Exception {
        String fileName = "C:\\Users\\Teodora\\My Thingy\\JAVA\\ADVANCED\\04.STREAMS, FILES AND DIRECTORIES\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        List<String> names = new ArrayList<>();

        names.add("Martin");
        names.add("Pesho");
        names.add("Gosho");
        names.add("Optimus");

        ObjectOutputStream outputStream =
                new ObjectOutputStream(new FileOutputStream("list.txt"));

        outputStream.writeObject(names);
        outputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("list.txt"));

        List<String> readName = (List<String>) inputStream.readObject();

        for (String name : readName) {
            System.out.println(name);
        }

    }
}
