package ADVANCED.EX10_STREAMS_FILES_AND_DIRECTORIES;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class E02_SumBytes {
    private static final String PATH = "src/ADVANCED/EX10_STREAMS_FILES_AND_DIRECTORIES/Resources/input.txt";

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String line = reader.readLine();

            long sum = 0;
            while (line != null) {

                for (int i = 0; i < line.length(); i++) {
                    sum += line.charAt(i);
                }

                line = reader.readLine();
            }
            System.out.println(sum);

        } catch (IOException io) {
            io.printStackTrace();
        }

    }
}
