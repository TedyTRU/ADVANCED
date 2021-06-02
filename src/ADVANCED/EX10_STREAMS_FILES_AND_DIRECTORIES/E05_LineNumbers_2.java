package ADVANCED.EX10_STREAMS_FILES_AND_DIRECTORIES;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class E05_LineNumbers_2 {

    private static final String INPUT_PATH = "src/ADVANCED/EX10_STREAMS_FILES_AND_DIRECTORIES/Resources/inputLineNumbers.txt";
    private static final String OUTPUT_PATH = "src/ADVANCED/EX10_STREAMS_FILES_AND_DIRECTORIES/Resources/output.txt";
    public static int countRow = 1;

    public static void main(String[] args) throws IOException {

        PrintWriter writer = new PrintWriter(OUTPUT_PATH);

        Files.readAllLines(Path.of(INPUT_PATH))
                .forEach(line ->
                        writer.println(countRow++ + ". " + line));

        writer.close();
    }
}
