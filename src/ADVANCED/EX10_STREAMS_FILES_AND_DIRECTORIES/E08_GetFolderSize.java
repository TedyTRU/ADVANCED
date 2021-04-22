package ADVANCED.EX10_STREAMS_FILES_AND_DIRECTORIES;

import java.io.*;

public class E08_GetFolderSize {

    private static final String DIR_PATH = "src/ADVANCED/EX10_STREAMS_FILES_AND_DIRECTORIES/Resources/Exercises Resources";
    private static final String OUTPUT_PATH = "src/ADVANCED/EX10_STREAMS_FILES_AND_DIRECTORIES/Resources/output.txt";

    public static void main(String[] args) throws IOException {


        try (PrintWriter writer = new PrintWriter(new FileWriter(OUTPUT_PATH))) {

            File folder = new File(DIR_PATH);
            int size = 0;
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    size += file.length();
                }

            }

            writer.println(String.format("Folder size: %d", size));

        }

    }
}
