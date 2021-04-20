package ADVANCED.LAB09_STREAMS_FILES_AND_DIRECTORIES;

import java.io.File;
import java.io.IOException;

public class L07_ListFiles {
    public static void main(String[] args) throws IOException {

        String fileName = "C:\\Users\\Teodora\\My Thingy\\JAVA\\ADVANCED\\04.STREAMS, FILES AND DIRECTORIES\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File file = new File(fileName);

        File[] innerFiles = file.listFiles();

        for (File innerFile : innerFiles) {
            if (!innerFile.isDirectory()) {
                System.out.printf("%s: [%d]%n", innerFile.getName(), innerFile.length());
            }
        }

        boolean delete = file.delete();

        if (delete) {
            System.out.println("Delete");
        } else {
            System.out.println("Still there");
        }
    }
}
