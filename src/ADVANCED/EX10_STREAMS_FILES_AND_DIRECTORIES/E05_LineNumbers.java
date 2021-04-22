package ADVANCED.EX10_STREAMS_FILES_AND_DIRECTORIES;

import java.io.*;

public class E05_LineNumbers {

    private static final String INPUT_PATH = "src/ADVANCED/EX10_STREAMS_FILES_AND_DIRECTORIES/Resources/inputLineNumbers.txt";
    private static final String OUTPUT_PATH = "src/ADVANCED/EX10_STREAMS_FILES_AND_DIRECTORIES/Resources/output.txt";

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH));
             PrintWriter writer = new PrintWriter(new FileWriter(OUTPUT_PATH))) {

            String line = reader.readLine();
            int number = 1;

            while (line != null) {

                writer.println(String.format("%d. %s", number, line));

                number++;
                line = reader.readLine();
            }

        } catch (IOException io) {
            io.printStackTrace();
        }

    }
}
