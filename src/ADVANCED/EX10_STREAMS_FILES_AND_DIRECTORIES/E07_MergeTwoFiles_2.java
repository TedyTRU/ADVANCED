package ADVANCED.EX10_STREAMS_FILES_AND_DIRECTORIES;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class E07_MergeTwoFiles_2 {

    private static final String INPUT_ONE = "src/ADVANCED/EX10_STREAMS_FILES_AND_DIRECTORIES/Resources/inputOne.txt";
    private static final String INPUT_TWO = "src/ADVANCED/EX10_STREAMS_FILES_AND_DIRECTORIES/Resources/inputTwo.txt";
    private static final String OUTPUT = "src/ADVANCED/EX10_STREAMS_FILES_AND_DIRECTORIES/Resources/output.txt";

    public static void main(String[] args) throws IOException {

        PrintWriter writer = new PrintWriter(OUTPUT);

        Files.readAllLines(Path.of(INPUT_ONE)).forEach(writer::println);
        Files.readAllLines(Path.of(INPUT_TWO)).forEach(writer::println);

        writer.close();

    }
}
