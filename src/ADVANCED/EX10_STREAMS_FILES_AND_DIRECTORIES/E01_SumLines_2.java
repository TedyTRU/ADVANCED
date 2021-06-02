package ADVANCED.EX10_STREAMS_FILES_AND_DIRECTORIES;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class E01_SumLines_2 {

    private static final String PATH = "src/ADVANCED/EX10_STREAMS_FILES_AND_DIRECTORIES/Resources/input.txt";

    public static void main(String[] args) throws IOException {

        Files.readAllLines(Path.of(PATH)).stream()
                .map(String::toCharArray)   // str -> str.toCharArray
                .forEach(charArray -> {
                    int sum = 0;
                    for (char symbol : charArray) {
                        sum += symbol;
                    }
                    System.out.println(sum);
                });

    }
}

