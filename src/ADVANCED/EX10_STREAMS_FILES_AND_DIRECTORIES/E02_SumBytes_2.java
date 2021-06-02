package ADVANCED.EX10_STREAMS_FILES_AND_DIRECTORIES;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class E02_SumBytes_2 {

    private static final String PATH = "src/ADVANCED/EX10_STREAMS_FILES_AND_DIRECTORIES/Resources/input.txt";

    public static void main(String[] args) throws IOException {

        long sum = 0;

        for (byte value : Files.readAllBytes(Path.of(PATH))) {
            if (value != 10 && value != 13) {
                sum += value;
            }
        }

        System.out.println(sum);
    }
}
